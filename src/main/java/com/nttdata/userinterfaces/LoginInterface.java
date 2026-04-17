package com.nttdata.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class LoginInterface {

    public static final Target USERNAME = Target.the("input user").located(By.id("user-name"));
    public static final Target PASSWORD = Target.the("input password").located(By.id("password"));
    public static final Target LOGIN_BUTTON = Target.the("button login").located(By.id("login-button"));
}
