package aut.testcreation.testcases;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.edge.EdgeDriver;

import java.time.Duration;

import static aut.testcreation.testcases.ManejoWebElement.driver;

public class Calculadora {
    By buscadorLocator = By.xpath("//input[@aria-label=\"Buscar\"]");

    @BeforeAll
    static void init() {
        WebDriverManager.edgedriver().setup();
    }

    @BeforeEach
    void setUp() {
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));

    }

    @Test
    void suma(){
        driver.navigate().to("https://www.google.com/search?client=firefox-b-d&q=calculadora");

    }
}
