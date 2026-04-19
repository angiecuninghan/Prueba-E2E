package com.nttdata.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class CartInterface {

    public static final Target CART = Target.the("button cart").located(By.xpath("//*[@id='shopping_cart_container']/a"));
    public static final Target CHECKOUT = Target.the("button checkout").located(By.id("checkout"));

}
