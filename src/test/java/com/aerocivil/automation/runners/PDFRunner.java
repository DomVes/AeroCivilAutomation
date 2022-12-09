package com.aerocivil.automation.runners;


import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features/validarPDF.feature",
        glue = "com/aerocivil/automation/stepdefinitions",
        snippets = SnippetType.CAMELCASE
)
public class PDFRunner {
}
