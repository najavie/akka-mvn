package pl.najavie;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import pl.najavie.actors.Repeater;
import pl.najavie.actors.RepeaterSimple;
import pl.najavie.actors.RepeaterWithParams;

import java.util.Date;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws InterruptedException {
        ActorSystem system = ActorSystem.create("system");
        ActorRef repeaterSimple = system.actorOf(Props.create(RepeaterSimple.class),"repeaterSimple");
        repeaterSimple.tell("Hello from simple repeater!",ActorRef.noSender());

        ActorRef repeater = system.actorOf(Props.create(Repeater.class),"repeater");
        repeater.tell("Hello from repeater", ActorRef.noSender());
        repeater.tell(new Date(),ActorRef.noSender());

        ActorRef repeaterWithParams = system.actorOf(Props.create(RepeaterWithParams.class,5),"repeaterWithParams");
        repeaterWithParams.tell("Hello from repeaterWithParams", ActorRef.noSender());
        Thread.sleep(1000);
        system.shutdown();
    }
}
