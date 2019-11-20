package lab4;

import akka.actor.AbstractActor;

public class ActorPerfomingTest extends AbstractActor {
    @Override
    public Receive createReceive() {
        return receiveBuilder()
                .match(MessageWithTest.class, msg -> )
                .build();
    }
}
