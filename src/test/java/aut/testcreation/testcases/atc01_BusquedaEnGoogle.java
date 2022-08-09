package aut.testcreation.testcases;

import aut.engine.selenium.DriverFactory;
import aut.engine.selenium.SeleniumTestBase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import aut.testcreation.pages.GoogleHomePage;

public class atc01_BusquedaEnGoogle extends SeleniumTestBase {
GoogleHomePage googleHomePage;
    @Test
    void busquedaGoogleTsoft(){
        googleHomePage = new GoogleHomePage(DriverFactory.getDriver());
        googleHomePage.ingresarAHomePage();
        googleHomePage.buscarEnBarraGoogle("TSOFT");
        String titulo = googleHomePage.getUrlTitle();
        Assertions.assertEquals("TSOFT - Buscar con Google", titulo);

    }
}
