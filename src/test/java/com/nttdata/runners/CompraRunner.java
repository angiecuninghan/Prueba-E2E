package com.nttdata.runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = "com.nttdata.glue",
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        tags = "@happyPath",
        plugin = {"pretty", "json:target/cucumber.json"}
)
public class CompraRunner {
}
