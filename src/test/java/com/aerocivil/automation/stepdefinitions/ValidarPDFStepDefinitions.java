package com.aerocivil.automation.stepdefinitions;

import com.aeroivil.automation.drivers.ChromeDriver;
import com.aeroivil.automation.questions.TituloPDF;
import com.aeroivil.automation.tasks.ValidarPDF;

import com.aeroivil.automation.utils.Excel;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

import java.io.IOException;
import java.sql.SQLOutput;

import static com.aeroivil.automation.drivers.ChromeDriver.driver;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.core.StringContains.containsString;


public class ValidarPDFStepDefinitions {


    Excel excel = new Excel();

    @Before
    public void setStage(){
        OnStage.setTheStage(new OnlineCast());
    }

    @Given("^Me encuentro en la pagina de aerocivil$")
    public void meEncuentroEnLaPaginaDeAerocivil() throws IOException {
        //Llamada al Excel para pedir la Url de la página
        OnStage.theActorCalled("Esteban").can(BrowseTheWeb.with(ChromeDriver.ChromeWebDriver().on(excel.leerDatoExcel("Dominios","Data.xlsx",1,0))));
    }
    @When("^Voy al modulo de balances$")
    public void voyAlModuloDeBalances() {
        //Invoca los métodos de la clase Buscador
        OnStage.theActorInTheSpotlight().attemptsTo(ValidarPDF.onbanistmo());
    }
    @Then("^Puedo ver PDF generado$")
    public void puedoVerPDFGenerado() throws IOException {
        //Valida el texto de la url con el esperado en el Excel
        OnStage.theActorInTheSpotlight()
                .should(seeThat(TituloPDF.onTheSite(),
                        containsString(excel.leerDatoExcel("Validar","Data.xlsx",1,2))));
    }
}
