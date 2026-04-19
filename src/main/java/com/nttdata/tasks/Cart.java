package com.nttdata.tasks;

import com.nttdata.userinterfaces.CartInterface;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class Cart implements Task {

    public static Cart continuar() {
        return Tasks.instrumented(Cart.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(CartInterface.CART),
                WaitUntil.the(CartInterface.CHECKOUT, isVisible()).forNoMoreThan(10).seconds(),
                Click.on(CartInterface.CHECKOUT)
        );
    }
}
