package com.nttdata.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class CartInterface {

    public static final Target CHECKOUT = Target.the("button checkout").located(By.id("checkout"));

}
