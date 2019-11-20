package lab4;

import akka.actor.AbstractActor;
import akka.actor.ActorRef;
import akka.actor.Props;

public class ActorRouter extends AbstractActor {
    private final ActorRef storageActor;
    private final ActorRef router;

    public ActorRouter (ActorRef storageActor, ActorRef router) {
        this.storageActor = getContext().actorOf(Props.create(ActorStorage.class));
        this.router = getContext().actorOf(Props.create(ActorRouter.class));
    }
}
