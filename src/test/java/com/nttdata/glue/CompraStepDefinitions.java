package com.nttdata.glue;

import com.nttdata.tasks.AddProducts;
import com.nttdata.tasks.Cart;
import com.nttdata.tasks.CompletarFormulario;
import com.nttdata.tasks.Login;
import com.nttdata.userinterfaces.CompraInterface;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.questions.targets.TheTarget;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.WebDriver;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static org.hamcrest.CoreMatchers.containsString;

public class CompraStepDefinitions {


    @Given("el ingreso al sistema Swag labs")
    public void abrirPagina() {

        OnStage.setTheStage(new OnlineCast());

        WebDriver driver = Serenity.getDriver();

        OnStage.theActorCalled("Usuario")
                .can(BrowseTheWeb.with(driver));

        OnStage.theActorInTheSpotlight().attemptsTo(
                Open.url("https://www.saucedemo.com/")
        );
    }


    @When("inicio de sesion con user {string} y password {string}")
    public void login(String user, String password) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                Login.conCredenciales(user, password)
        );
    }

    @And("Seleccionar dos productos")
    public void seleccionarProductos() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                AddProducts.alCarrito()
        );
    }

    @And("Visualizar carrito")
    public void verCarrito() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                Cart.continuar()
        );
    }

    @And("Completar el formulario de compra con el archivo {string}")
    public void completarFormulario(String archivo) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                CompletarFormulario.conDatos(archivo)
        );
    }

    @Then("Visualizar mensaje {string}")
    public void validarMensaje(String mensajeEsperado) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                WaitUntil.the(CompraInterface.CONFIRMATION_MESSAGE, isVisible()).forNoMoreThan(10).seconds()
        );

        OnStage.theActorInTheSpotlight().should(
                seeThat(TheTarget.textOf(CompraInterface.CONFIRMATION_MESSAGE), containsString(mensajeEsperado))
        );
    }
}







