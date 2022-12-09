package com.aeroivil.automation.interactions;

import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;

import static com.aeroivil.automation.drivers.ChromeDriver.driver;

public class CloseWindow implements Interaction {
    @Override
    public <T extends Actor> void performAs(T actor) {
        BrowseTheWeb.as(actor).getDriver().navigate().forward();
    }

    public static CloseWindow now(){
        return Instrumented.instanceOf(CloseWindow.class).withProperties();
    }
}
