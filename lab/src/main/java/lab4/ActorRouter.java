package lab4;

import akka.actor.AbstractActor;
import akka.actor.ActorRef;
import akka.actor.Props;
import akka.routing.RoundRobinPool;

public class ActorRouter extends AbstractActor {
    private final ActorRef storageActor;
    private final ActorRef router;

    public ActorRouter (ActorRef storageActor, ActorRef router) {
        this.storageActor = getContext().actorOf(Props.create(ActorStorage.class));
        this.router = getContext().actorOf(new RoundRobinPool(5).props(Props.create(ActorPerfomingTest.class)));
    }

    @Override
    public Receive createReceive() {
        return receiveBuilder()
                .match(RequestMessageOfPackageTestResult.class, msg -> storageActor.tell(msg, sender()))
                .match(FunctionFromQuery.class, msg -> {
                    int len = msg.getTests().length;
                    for (int i = 0; i < len; i++){
                        router.tell(new MessageWithResults(msg.getPackageId(), msg.getJsScript(), msg.getFunctionName(), ), storageActor);
                    }
                })
                .build();
    }
}
