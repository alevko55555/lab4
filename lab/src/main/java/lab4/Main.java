package lab4;


public class Main {
    ActorSystem system = ActorSystem.create("test");
    ActorRef storeActor = system.actorOf(
    );
storeActor.tell(
        new StoreActor.StoreMessage("test", "test"),
        ActorRef.noSender()
        );
}
