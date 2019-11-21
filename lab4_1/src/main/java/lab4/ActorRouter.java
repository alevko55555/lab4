package lab4;

import akka.actor.AbstractActor;
import akka.actor.ActorRef;
import akka.actor.Props;
import akka.routing.RoundRobinPool;


import java.util.stream.Stream;

public class ActorRouter extends AbstractActor {
    private static final int POOL_NUM = 5;
    private final ActorRef storageActor;
    private final ActorRef router;

    public ActorRouter () {
        this.storageActor = getContext().actorOf(Props.create(ActorStorage.class));
        this.router = getContext().actorOf(new RoundRobinPool(POOL_NUM).props(Props.create(ActorPerfomingTest.class)));
    }

    @Override
    public Receive createReceive() {
        return receiveBuilder()
                .match(RequestMessageOfPackageTestResult.class, msg -> storageActor.tell(msg, sender()))
                .match(FunctionFromQuery.class, msg ->
                        Stream.of(msg.getTests())
                                .map(test -> new MessageWithTest(msg.getPackageId(), msg.getJsScript(), msg.getFunctionName(), test))
                                .forEach(msgrouter -> router.tell(msgrouter, storageActor)))
                .build();
    }
}
