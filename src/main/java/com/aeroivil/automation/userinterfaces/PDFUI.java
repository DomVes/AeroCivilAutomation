package com.aeroivil.automation.userinterfaces;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.webdriver.jquery.ByJQuerySelector;

public class PDFUI {

    public static final Target BTN_TRANSPARENCIA = Target.the("Boton transparencia")
            .locatedBy("//a[@href='/transparencia']");

    public static final Target BTN_PRES = Target.the("Boton Presupuesto")
            .locatedBy("//div[@id='WebPartWPQ16']");

    public static final Target BTN_PRESUPUESTO = Target.the("Boton Presupuestos")
            .locatedBy("//a[contains(text(),'4.1  Presupuesto general de ingresos')]");

    public static final Target BTN_ESTADOS = Target.the("Boton estados financieros")
            .locatedBy("//a[@href='https://www.aerocivil.gov.co/atencion/presupuesto/estados-financieros']");

    public static final Target BTN_BALANCES = Target.the("Boton Balances")
            .locatedBy("//div[@id='WebPartWPQ10']");

    public static final Target BTN_PDF = Target.the("Boton ver PDF")
            .locatedBy("//h2[contains(text(),'31 de Octubre de 2022')]");

    public static final Target SPAN_TITLE = Target.the("Titulo del PDF")
            .locatedBy("/html/head/title");


}
