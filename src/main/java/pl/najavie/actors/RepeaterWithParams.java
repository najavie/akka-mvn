package pl.najavie.actors;

import akka.actor.AbstractActor;
import akka.actor.Props;
import akka.japi.pf.ReceiveBuilder;

import java.util.stream.IntStream;

/**
 * Created by krzysztof on 1/24/15.
 */
public class RepeaterWithParams extends AbstractActor {

    public static Props props(Integer count) {
        return Props.create(RepeaterWithParams.class, () -> new RepeaterWithParams(count));
    }

    private final Integer count;

    public RepeaterWithParams(Integer count) {
        this.count = count;
        receive(ReceiveBuilder.match(String.class, message ->
                IntStream.range(0, count).forEach(element -> System.out.println(message))
        ).build());
    }
}
