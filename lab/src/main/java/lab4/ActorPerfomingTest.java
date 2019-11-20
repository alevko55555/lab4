package lab4;

import akka.actor.AbstractActor;
import akka.actor.ActorRef;

public class ActorPerfomingTest extends AbstractActor {
    @Override
    public Receive createReceive() {
        return receiveBuilder()
                .match(MessageWithTest.class, msg -> getSender()
                        .tell(new MessageWithTest(msg.getPackageId(),msg.getTest(), executionTest(msg))), ActorRef.noSender())
                .build();
    }
}

private executionTest (MessageWithTest msg) {
    ScriptEngine engine = new
            ScriptEngineManager().getEngineByName("nashorn");
    engine.eval(msg.getJsScript());
    Invocable invocable = (Invocable) engine;
    return invocable.invokeFunction(msg.getFunctionName(), msg.getTest().getParams()).toString();
}
