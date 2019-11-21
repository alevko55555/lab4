package lab4;

import akka.actor.AbstractActor;
import akka.actor.ActorRef;
import akka.dispatch.japi;
import scala.collection.immutable.List;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ActorStorage extends AbstractActor {
    private HashMap<Long, List<Result>> storage = new HashMap<>();

    @Override
    public Receive createReceive() {
        return receiveBuilder()
                .create()
                .match(MessageWithResultOfOneTest.class,
                        requre -> getSender().tell(
                                storage.get(requre.getPackageId()).toList(),
                                ActorRef.noSender()
                        ))
                .match(RequestMessageOfPackageTestResult.class,
                        msg -> getSender().tell(
                                new TestResults(msg.getPackageId(), storage.get(msg.getPackageId())),
                                ActorRef.noSender()
                        ));
    }
}