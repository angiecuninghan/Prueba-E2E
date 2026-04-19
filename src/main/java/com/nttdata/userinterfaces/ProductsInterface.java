package com.nttdata.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class ProductsInterface {
    public static final Target PRODUCT_1 = Target.the("agregar mochila").located(By.id("add-to-cart-sauce-labs-backpack"));
    public static final Target PRODUCT_2 = Target.the("agregar linterna").located(By.id("add-to-cart-sauce-labs-bike-light"));
}
