package aut.testcreation.testcases;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import java.time.Duration;

import static aut.testcreation.testcases.ManejoWebElement.driver;

public class TraductorEjer {
    //LOCALIZADORES
    By textAreaOrigen = By.xpath("//div/textarea[@class=\"er8xn\"]");
    By btnDespliegueIdiomas = By.xpath("");
    By btnIngles = By.xpath("");


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
    void traduccionIngles(){
        System.out.println("Traduccion en ingles");
        driver.navigate().to("https://translate.google.com/");

        String respuesta;

    }
}
