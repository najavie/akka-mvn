package pl.najavie.actors;


import akka.actor.AbstractActor;
import akka.actor.Props;
import akka.japi.pf.ReceiveBuilder;
import pl.najavie.utils.Command;
import scala.PartialFunction;

/**
 * Created by krzysztof on 1/21/15.
 */
public class Repeater extends AbstractActor {

    Repeater() {
        receive(repeat().orElse(notFound()));
    }


    protected PartialFunction repeat() {
        return ReceiveBuilder.match(
                String.class, message -> System.out.println(message)
        ).build();
    }

    protected PartialFunction notFound() {
        return ReceiveBuilder.matchAny(
                object -> System.out.println("BRAK METODY DLA "+object.getClass())
        ).build();
    }

    public static Props props() {
        return Props.create(Repeater.class, Repeater::new);
    }
}
