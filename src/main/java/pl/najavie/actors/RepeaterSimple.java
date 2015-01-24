package pl.najavie.actors;

import akka.actor.AbstractActor;
import akka.actor.Props;
import akka.japi.pf.ReceiveBuilder;

/**
 * Created by krzysztof on 1/21/15.
 */
public class RepeaterSimple extends AbstractActor {

    RepeaterSimple() {

        receive(ReceiveBuilder.match(String.class, message -> System.out.println(message)).build());
    }

    public static Props props() {
        return Props.create(RepeaterSimple.class, RepeaterSimple::new);
    }
}
