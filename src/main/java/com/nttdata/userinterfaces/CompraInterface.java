package com.nttdata.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class CompraInterface {

    public static final Target FIRST_NAME = Target.the("input nombre").located(By.id("first-name"));
    public static final Target LAST_NAME = Target.the("input apellido").located(By.id("last-name"));
    public static final Target ZIP_CODE = Target.the("input postal").located(By.id("postal-code"));
    public static final Target CONTINUE_BUTTON = Target.the("button continuar").located(By.id("continue"));
    public static final Target FINISH_BUTTON = Target.the("button finish").located(By.id("finish"));
    public static final Target CONFIRMATION_MESSAGE = Target.the("mensaje de confirmación").located(By.className("complete-header"));

}
