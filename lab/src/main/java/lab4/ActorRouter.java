package lab4;

import akka.actor.AbstractActor;
import akka.actor.ActorRef;
import akka.actor.Props;

public class ActorRouter extends AbstractActor {
    Props props1 = Props.create(ActorRouter.class);
    public ActorRef router;
}
