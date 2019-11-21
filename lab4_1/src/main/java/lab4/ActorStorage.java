package lab4;

import akka.actor.AbstractActor;
import akka.actor.ActorRef;
import akka.dispatch.japi;
import scala.collection.immutable.List;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ActorStorage extends AbstractActor {
    private HashMap<Long, ArrayList<Result>> storage = new HashMap<>();

    @Override
    public Receive createReceive() {
        return receiveBuilder()
                .create()
                .match(MessageWithResultOfOneTest.class,
                        msg -> {
                    if (storage.containsKey(msg.getPackageId())) {
                        ArrayList<Result> tests = storage.get(msg.getPackageId());
                        tests.add(msg.getResult());
                        storage.put(msg.getPackageId(), tests);
                    } else {
                        ArrayList<Result> tests = new ArrayList<>();
                        tests.add(msg.getResult());
                        storage.put(msg.getPackageId(), tests);
                    }
                        })
                .match(RequestMessageOfPackageTestResult.class,
                        msg -> getSender().tell(
                                new TestResults(msg.getPackageId(), storage.get(msg.getPackageId())),
                                ActorRef.noSender()
                        ))
                .build();
    }
}