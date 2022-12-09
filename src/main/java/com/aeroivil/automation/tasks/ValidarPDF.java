package com.aeroivil.automation.tasks;

import com.aeroivil.automation.interactions.SwitchToNewTab;
import com.aeroivil.automation.userinterfaces.PDFUI;
import com.aeroivil.automation.utils.Excel;
import com.aeroivil.automation.utils.GuardarExcel;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.JavaScriptClick;
import net.serenitybdd.screenplay.waits.WaitUntil;

import java.io.IOException;

import static com.aeroivil.automation.drivers.ChromeDriver.driver;
import static com.aeroivil.automation.userinterfaces.PDFUI.BTN_BALANCES;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class ValidarPDF implements Task {


    GuardarExcel excel = new GuardarExcel();
    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                JavaScriptClick.on(PDFUI.BTN_TRANSPARENCIA),
                WaitUntil.the(PDFUI.BTN_PRES, isVisible()),
                JavaScriptClick.on(PDFUI.BTN_PRES),
                WaitUntil.the(PDFUI.BTN_PRESUPUESTO, isVisible()),
                JavaScriptClick.on(PDFUI.BTN_PRESUPUESTO),
                WaitUntil.the(PDFUI.BTN_ESTADOS, isVisible()),
                JavaScriptClick.on(PDFUI.BTN_ESTADOS),
                SwitchToNewTab.change(),
                WaitUntil.the(BTN_BALANCES, isVisible()),
                JavaScriptClick.on(BTN_BALANCES),
                WaitUntil.the(PDFUI.BTN_PDF, isVisible()),
                JavaScriptClick.on(PDFUI.BTN_PDF)
        );
        String pageUrl = driver.getCurrentUrl();
        try {
            excel.writeCellValue("Data.xlsx", "Validar",1,1,pageUrl);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public static ValidarPDF onbanistmo(){
        return Instrumented.instanceOf(ValidarPDF.class).withProperties();
    }
}
