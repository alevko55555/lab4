package lab4;


import akka.actor.ActorSystem;
import akka.http.javadsl.server.AllDirectives;

public class Main extends AllDirectives {
    private static final int SERVER_PORT =  8080;

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
        ActorRef storeActor = system.actorOf(
                Props.create(ActorRouter.class)
        );
        /*
        storeActor.tell(
                new ActorStorage().StoreMessage("test", "test"),
                ActorRef.noSender()
        );*/
        return null;
    }
}
