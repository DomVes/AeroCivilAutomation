package com.aeroivil.automation.questions;

import com.aeroivil.automation.utils.GuardarExcel;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import static com.aeroivil.automation.drivers.ChromeDriver.driver;
import static com.aeroivil.automation.userinterfaces.PDFUI.SPAN_TITLE;

public class TituloPDF implements Question<String>{

    @Override
    public String answeredBy(Actor actor) {
        //String pagina = SPAN_TITLE.resolveFor(actor).getText();
        //System.out.println(pagina);
        //return SPAN_TITLE.resolveFor(actor).getText();
        String pageUrl = driver.getCurrentUrl();
        System.out.println(pageUrl);
        return pageUrl;
    }

    public static Question<String> onTheSite() {return new TituloPDF();
    }
}
