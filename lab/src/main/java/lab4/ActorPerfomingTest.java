package lab4;

import akka.actor.AbstractActor;
import akka.actor.ActorRef;

public class ActorPerfomingTest extends AbstractActor {
    @Override
    public Receive createReceive() {
        return receiveBuilder()
                .match(MessageWithTest.class, msg -> getSender()
                        .tell(new MessageWithTest(msg.getPackageId(),msg.getTest(), msg.getTest())), ActorRef.noSender())
                .build();
    }
}
