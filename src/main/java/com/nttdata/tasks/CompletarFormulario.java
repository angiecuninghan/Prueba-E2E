package com.nttdata.tasks;

import com.nttdata.userinterfaces.CompraInterface;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

import java.io.FileReader;
import java.io.Reader;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;

public class CompletarFormulario implements Task {

    private final String archivo;

    public CompletarFormulario(String archivo) {
        this.archivo = archivo;
    }

    public static CompletarFormulario conDatos(String archivo) {
        return Tasks.instrumented(CompletarFormulario.class, archivo);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        try {
            Reader reader = new FileReader("src/test/resources/data/" + archivo);

            Iterable<CSVRecord> records = CSVFormat.DEFAULT
                    .withFirstRecordAsHeader()
                    .parse(reader);

            for (CSVRecord record : records) {

                String firstname = record.get("firstname");
                String lastname = record.get("lastname");
                String zipcode = record.get("zipcode");

                actor.attemptsTo(
                        Enter.theValue(firstname).into(CompraInterface.FIRST_NAME),
                        Enter.theValue(lastname).into(CompraInterface.LAST_NAME),
                        Enter.theValue(zipcode).into(CompraInterface.ZIP_CODE),
                        Click.on(CompraInterface.CONTINUE_BUTTON),
                        Scroll.to(CompraInterface.FINISH_BUTTON),
                        WaitUntil.the(CompraInterface.FINISH_BUTTON, isClickable()).forNoMoreThan(10).seconds(),
                        Click.on(CompraInterface.FINISH_BUTTON)

                );
            }

        } catch (Exception e) {
            throw new RuntimeException("Error leyendo CSV", e);
        }
    }
}
