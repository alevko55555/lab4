package lab4;

import akka.actor.AbstractActor;
import scala.collection.immutable.List;

public class ActorStorage extends AbstractActor {
    private final Map<Long, List<Result>> storage;

    @Override
    public Receive createReceive() {
        return null;
    }
}