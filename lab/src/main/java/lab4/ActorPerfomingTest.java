package lab4;

import akka.actor.AbstractActor;
import akka.actor.ActorRef;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

public class ActorPerfomingTest extends AbstractActor {
    @Override
    public Receive createReceive() {
        return receiveBuilder()
                .match(MessageWithTest.class, msg -> getSender().tell(new MessageWithTest(msg.getPackageId(), msg.getJsScript(), msg.getFunctionName(), executTest(msg)), ActorRef.noSender()))
                .build();
    }

    private Test executTest (MessageWithTest msg) {
        ScriptEngine engine = new
                ScriptEngineManager().getEngineByName("nashorn");
        engine.eval(msg.getJsScript());
        Invocable invocable = (Invocable) engine;
        return invocable.invokeFunction(msg.getFunctionName(), msg.getTest().getParams()).toString();
    }
}
