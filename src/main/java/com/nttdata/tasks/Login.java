package com.nttdata.tasks;

import com.nttdata.userinterfaces.LoginInterface;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

public class Login implements Task {

    private final String user;
    private final String password;

    public Login(String user, String password) {
        this.user = user;
        this.password = password;
    }

    public static Login conCredenciales(String user, String password) {
        return Tasks.instrumented(Login.class, user, password);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue(user).into(LoginInterface.USERNAME),
                Enter.theValue(password).into(LoginInterface.PASSWORD),
                Click.on(LoginInterface.LOGIN_BUTTON)

        );
    }
}
