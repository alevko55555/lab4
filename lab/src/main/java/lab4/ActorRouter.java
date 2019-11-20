package lab4;

import akka.actor.AbstractActor;
import akka.actor.ActorRef;
import akka.actor.Props;

public class ActorRouter extends AbstractActor {
    public
    final ActorRef router;

    public ActorRouter (ActorRef router) {
        this.router = getContext().actorOf(Props.create(ActorRouter.class));
    }
}
