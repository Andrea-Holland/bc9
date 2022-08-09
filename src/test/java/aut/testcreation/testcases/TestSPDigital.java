package aut.testcreation.testcases;

import aut.engine.selenium.DriverFactory;
import aut.engine.selenium.SeleniumTestBase;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static aut.engine.selenium.DriverFactory.*;

public class TestSPDigital extends SeleniumTestBase {

    @Test
    public void testingSpDigital() throws InterruptedException {
        WebDriver driver = getDriver();
        driver.navigate().to("https://www.spdigital.cl");

        By buscador = By.xpath("//*[@id=\"gatsby-focus-wrapper\"]/div/div[2]/div/span[1]/form/div/input");
        By btnBuscar = By.xpath("//*[@id=\"gatsby-focus-wrapper\"]/div/div[2]/div/span[1]/form/div/button");
        By mensajeNoEncontrado = By.xpath("//*[@id=\"gatsby-focus-wrapper\"]/div[4]/section[1]/div/div[2]/div[2]/span[1]");

        WebElement webElementbuscador = driver.findElement(buscador);
        WebElement webElementbtnbuscar = driver.findElement(btnBuscar);

        webElementbuscador.sendKeys("asfgt");
        webElementbtnbuscar.click();
        Thread.sleep(5000);

        WebElement webElementmensajeNoEncontrado = driver.findElement(mensajeNoEncontrado);
        String respuesta = webElementmensajeNoEncontrado.getText();


        Assertions.assertEquals("0 - 0 de 0 productos para tu búsqueda: \"asfgt\"", respuesta);
    }
}
