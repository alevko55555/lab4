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
        this.router = getContext().actorOf(new RoundRobinPool(5).props(ActorPerfomingTest));
    }
}
