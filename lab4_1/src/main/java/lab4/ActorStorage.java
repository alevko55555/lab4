package lab4;

import akka.actor.AbstractActor;
import scala.collection.immutable.List;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ActorStorage extends AbstractActor {
    private HashMap<Long, List<Result>> storahe;

    @Override
    public Receive createReceive() {
        return null;
    }
}