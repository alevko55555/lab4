package lab4;


import akka.NotUsed;
import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import akka.http.javadsl.ConnectHttp;
import akka.http.javadsl.Http;
import akka.http.javadsl.ServerBinding;
import akka.http.javadsl.marshallers.jackson.Jackson;
import akka.http.javadsl.model.HttpRequest;
import akka.http.javadsl.model.HttpResponse;
import akka.http.javadsl.server.AllDirectives;
import akka.http.javadsl.server.Route;
import akka.pattern.Patterns;
import akka.stream.ActorMaterializer;
import akka.stream.javadsl.Flow;
import scala.concurrent.Future;

import java.io.IOException;
import java.util.concurrent.CompletionStage;
import java.util.regex.Pattern;

public class Main extends AllDirectives {
    private static final int SERVER_PORT =  8080;
    private static final long TIMEOUT_MILLIS = 5000;

    public static void main(String[] args) throws IOException {
        ActorSystem system = ActorSystem.create("routes");
        final Http http = Http.get(system);
        final ActorMaterializer materializer = ActorMaterializer.create(system);
        Main instance = new Main();
        final Flow<HttpRequest, HttpResponse, NotUsed> routeFlow =
                instance.createRoute(system).flow(system, materializer);
        final CompletionStage<ServerBinding> binding = http.bindAndHandle(
                routeFlow,
                ConnectHttp.toHost("localhost", SERVER_PORT),
                materializer
        );
        System.out.println("Server online at http://localhost:8080/\nPress RETURN to stop...");
        System.in.read();
        binding
                .thenCompose(ServerBinding::unbind)
                .thenAccept(unbound -> system.terminate());
    }

    private Route createRoute(ActorSystem system) {
        ActorRef storeActor = system.actorOf(Props.create(ActorRouter.class));
        return route(
                post(() ->
                        entity(Jackson.unmarshaller(FunctionFromQuery.class),
                                msg -> {
                            storeActor.tell(msg, ActorRef.noSender());
                            return complete("Run test\n");
                        })
                ),
                get(() ->
                        parameter("packageId", packageId -> {
                                    Future<Object> result = (Future<Object>) Patterns.ask(
                                            storeActor,
                                            new RequestMessageOfPackageTestResult(Long.parseLong(packageId)),
                                            TIMEOUT_MILLIS);
                                    return completeOKWithFuture(result, Jackson.marshaller());
                                })
                        )
        );
    }
}

/*
{
"packageId":"11",
"jsScript":"var divideFn = function(a,b) { return a/b} ",
"functionName":"divideFn",
"tests": [
{"testName":"test1",
"expectedResult":"2.0",
"params":[2,1]
},
{"testName":"test2",
"expectedResult":"2.0",
"params":[4,2]
}
]
}
 */
