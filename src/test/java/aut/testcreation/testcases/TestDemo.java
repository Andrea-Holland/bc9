package aut.testcreation.testcases;

import aut.engine.selenium.DriverFactory;
import aut.engine.selenium.SeleniumTestBase;
import io.qameta.allure.Description;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;

import static aut.engine.utils.Constants.BASE_URL_AUT;

public class TestDemo extends SeleniumTestBase { //todos los test a partir de ahora heredan de la clase seleniumbase

    WebDriver driver; //driver es el navegador
    //es una clase que pertenece a la api de selenium y nos permite crear una instancia de browser al cual voy a generar pruebas
    //se crea a traves del driver factory

    @Test
    @Description("Test creado para bootcamp 9 tsoft")
    public void testDemo() throws InterruptedException {
        driver = DriverFactory.getDriver(); //crea el browser de la prueba
        //es el browser instanciado

        //ACCIONES DEL NAVEGADOR
            //abre navegador web
        driver.get(BASE_URL_AUT); //google.com

            //detectar botones en el browser
        WebElement btnSuerte = driver.findElement(By.name("btnI"));

        JavascriptExecutor js= (JavascriptExecutor)driver; //llamado al ejecutor de JS para detectar Scripts
        js.executeScript("console.log(' Hola BC9 ')"); //muestra un msj por consola para desarroladores en el driver
        js.executeScript("arguments[0].click();",btnSuerte); //click en el boton


        //VENTANAS Y TABS = como movernos
        /*String ventana1 = driver.getWindowHandle();

        driver.switchTo().newWindow(WindowType.WINDOW); //obtenemos su valor
        String ventana2 = driver.getWindowHandle(); //(valor que nos sirve para movernos entre ventanas y tab.

        driver.switchTo().newWindow(WindowType.TAB);
        String pestanha = driver.getWindowHandle();

        driver.switchTo().window(ventana1);
        driver.get(BASE_URL_AUT);

        driver.switchTo().window(ventana2);
        driver.get(BASE_URL_AUT);*/


        //NAVEGACION BASICA DEL DRIVER

        /*String nombreUrlActual = driver.getCurrentUrl(); //toma el link del driver
        String tituloWeb = driver.getTitle(); //traigo el valor del titulo
        System.out.println("Me encuentro en: " + nombreUrlActual + " y su titulo es: " + tituloWeb);
        Thread.sleep(3000);
        driver.navigate().to("https://selenium.dev"); //metodo navegar //to(...) ahi va la pagina que se instancio
        Thread.sleep(3000);
        nombreUrlActual = driver.getCurrentUrl();
        tituloWeb = driver.getTitle();
        System.out.println("Me encuentro en: " + nombreUrlActual + " y su titulo es: " + tituloWeb);

            //ir hacia atras, adelante y actualizar en el browser
        driver.navigate().back(); //volver
        nombreUrlActual = driver.getCurrentUrl();
        tituloWeb = driver.getTitle();
        System.out.println("Me encuentro en: " + nombreUrlActual + " y su titulo es: " + tituloWeb);

        driver.navigate().forward(); //ir hacia adelante
        nombreUrlActual = driver.getCurrentUrl();
        tituloWeb = driver.getTitle();
        System.out.println("Me encuentro en: " + nombreUrlActual + " y su titulo es: " + tituloWeb);

        driver.navigate().refresh(); //F5

        //POSICIONAMIENTO DEL BROWSER
            //para conocer el alto y el ancho de la ventana del navegador
        /*int alto = driver.manage().window().getSize().getHeight();
        int ancho = driver.manage().window().getSize().getWidth();*/ //Una opcion es esta


        /*Dimension altoAncho = driver.manage().window().getSize(); //clase para determinar alto y ancho
        int ancho = altoAncho.getWidth();
        int alto = altoAncho.getHeight(); //usando la clase, llamamos al objeto

        driver.manage().window().setSize(new Dimension(800,600));

            //posicion del browser
        int posicionX= driver.manage().window().getPosition().getX();
        int posicionY= driver.manage().window().getPosition().getY();

        Point posicionDelDriver = driver.manage().window().getPosition();
        posicionX= posicionDelDriver.getX();
        posicionY= posicionDelDriver.getY();

        driver.manage().window().setPosition(new Point(0,0));*/


        Assertions.assertTrue(true);

        //
    }
}