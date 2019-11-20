package lab4;

import akka.actor.AbstractActor;
import akka.actor.ActorRef;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class ActorPerfomingTest extends AbstractActor {
    @Override
    public Receive createReceive() {
        return receiveBuilder()
                .match(MessageWithTest.class, msg -> getSender().tell(new MessageWithTest(msg.getPackageId(), msg.getJsScript(), msg.getFunctionName(), executTest(msg)), ActorRef.noSender()))
                .build();
    }

    private Test executTest (MessageWithTest msg) {
        try {
            ScriptEngine engine = new
                    ScriptEngineManager().getEngineByName("nashorn");
            engine.eval(msg.getJsScript());
            Invocable invocable = (Invocable) engine;
            return invocable.invokeFunction(msg.getFunctionName(), msg.getTest().getParams()).toString();
        }
        catch (ScriptException except){
            return ;
        }
    }
}
