package com.nttdata.runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
//@RunWith(SerenityRunner.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = "com.nttdata.glue",
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        tags = "@happyPath"


)
public class CompraRunner {
}
