package lab4;


import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import akka.http.javadsl.server.AllDirectives;

public class Main extends AllDirectives {
    public static void main(){
        ActorSystem system = ActorSystem.create("test");
        ActorRef storeActor = system.actorOf(
                Props.create(StoreActor.class)
        );
        storeActor.tell(
                new StoreActor.StoreMessage("test", "test"),
                ActorRef.noSender()
        );
    }
}
