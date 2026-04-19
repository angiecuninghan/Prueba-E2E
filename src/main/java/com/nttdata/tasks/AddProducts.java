package com.nttdata.tasks;

import com.nttdata.userinterfaces.ProductsInterface;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class AddProducts implements Task {

    public static AddProducts alCarrito() {
        return Tasks.instrumented(AddProducts.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(ProductsInterface.PRODUCT_1, isVisible()).forNoMoreThan(10).seconds(),
                Click.on(ProductsInterface.PRODUCT_1),
                Click.on(ProductsInterface.PRODUCT_2)

        );
    }

}
