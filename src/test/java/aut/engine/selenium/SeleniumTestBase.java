package aut.engine.selenium;

import aut.engine.utils.LoadProperties;
import io.qameta.allure.Description;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;

import java.util.Properties;

public class SeleniumTestBase {

    private DriverFactory driverFactory;
    WebDriver driver;
    static Properties properties;

    @BeforeAll
    @Description("Carga de propiedades desde config.properties")
    public static void setupTest() {
        properties = LoadProperties.loadProperties();
    }

    @BeforeEach
    @Description("Configuracion de WebDriver")
    void webDriverSetup(){
        String browserName = properties.getProperty("browser");
        driverFactory = new DriverFactory();
        driver = driverFactory.inicializarDriver(browserName);
    }

    @AfterEach
    @Description ("Cierre de WebDriver")
    void close(){
        driver.quit();
    } //instancia creada ya no esta disponible, se cierra el navegador

}
