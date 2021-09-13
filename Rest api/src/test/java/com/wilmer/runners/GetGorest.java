package com.wilmer.runners;

import net.serenitybdd.cucumber.CucumberWithSerenity;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        glue = "com.wilmer.stepdefinitions",
        features = "src/test/resources/com.wilmer.features/get_gorest.feature",
        snippets = CucumberOptions.SnippetType.CAMELCASE
)

public class GetGorest {

}
