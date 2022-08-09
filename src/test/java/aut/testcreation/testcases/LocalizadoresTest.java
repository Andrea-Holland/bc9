package aut.testcreation.testcases;

import aut.engine.selenium.DriverFactory;
import aut.engine.selenium.SeleniumTestBase;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static aut.engine.utils.Constants.BASE_URL_AUT;

public class LocalizadoresTest extends SeleniumTestBase
{

    WebDriver driver;
    //LOCALIZADORES (poder identificar el objeto en tiempo de edicion, guardarlo en una variable tipo by,
    // para luego generar un elemento en tiempo de ejecucion)
    By btnEnviarA = By.xpath("/html/body/header/div/div[2]/ul/li[1]/a");
    By popElegiDondeRecibe = By.id("root-app");
    //By cerrarPopElegi = By.xpath("//*[@id=\"root-app\"]/div/div[1]/span");
    By btnEntendido = By.xpath("/html/body/div[2]/div[1]/div[2]/button[1]");


    //PRUEBAS PERSONALES
    By buscador = By.xpath("//*[@id=\"cb1-edit\"]");
    By btnBuscar = By.xpath("/html/body/header/div/form/button/div");
    By casillaSeleccion = By.xpath("//input[@id='categorySearch']");


    @Test
    void localizandoElementos() throws InterruptedException
    {
        driver = DriverFactory.getDriver();
        driver.navigate().to(BASE_URL_AUT);

        if(driver.findElement(btnEntendido).isEnabled())
        {
            driver.findElement(btnEntendido).click();
        }
        //ya deberia estar disponible el elemento web que puedo identificar con el localizador

        WebElement webElementbtnEnviarA = driver.findElement(btnEnviarA);

        if(webElementbtnEnviarA.isDisplayed())//si el elemento esta disponible
        {
            String text = webElementbtnEnviarA.getText();
            System.out.println(text);
            webElementbtnEnviarA.click();
        }

        driver.findElement(popElegiDondeRecibe);
        //Thread.sleep(3000);

        //de esta manera crea un elemento en tiempo de ejecucion
        if(driver.findElement(By.name("cerrarPop")).isDisplayed())
        {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("$x(\"(//*[@id=\"root-app\"]/div/div[1]/span\").click()");
            //WebElement webElementCerrarPop = driver.findElement(cerrarPopElegi);
            //webElementCerrarPop.click();

        }
        Thread.sleep(3000);


        WebElement webElementbuscador = driver.findElement(buscador);
        WebElement webElementbtnbuscar = driver.findElement(btnBuscar);


        if (webElementbuscador.isEnabled()){
            Thread.sleep(3000);
            webElementbuscador.sendKeys("gomitas");
            Thread.sleep(3000);
            webElementbtnbuscar.click();

        }
        WebElement webElementcasillaSeleccion = driver.findElement(casillaSeleccion);

        webElementcasillaSeleccion.click();
        Thread.sleep(3000);
    }
}
