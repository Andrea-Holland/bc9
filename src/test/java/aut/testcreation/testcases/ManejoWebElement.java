package aut.testcreation.testcases;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;

public class ManejoWebElement {

    static WebDriver driver;
    By dropdownLocator = By.id("dropdown");
    By check1 = By.xpath("//form[@id='checkboxes']/input[1]");
    By check2 = By.xpath("//form[@id='checkboxes']/input[2]");
    By btnEnabledLocator = By.xpath("//li[@id=\"ui-id-3\"]/a");
    By btnDownloadLocator = By.xpath("//li[@id=\"ui-id-4\"]/a");
    By btnPdfLocator = By.xpath("//li[@id=\"ui-id-5\"]/a");
    By iframe = By.id("mce_0_ifr");
    By iframeText = By.id("tinymce");




    @BeforeAll
    static void init() {
        WebDriverManager.edgedriver().setup();
    }

    @BeforeEach
    void setUp() {
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        //espera implicita: espera al menos 5 segundos antes de lanzar que no encontro el elemento
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @Test
    void dropdown() {
        System.out.println("Test Dropdown");
        driver.navigate().to("https://the-internet.herokuapp.com/dropdown");

        //WebElement
        WebElement dropdown = driver.findElement(dropdownLocator);

        //Select --> select
        Select select = new Select(dropdown);

        select.selectByValue("1");
        System.out.println(select.getFirstSelectedOption().getText());
        select.selectByValue("2");
        System.out.println(select.getFirstSelectedOption().getText());

        select.selectByIndex(1);
        System.out.println(select.getFirstSelectedOption().getText());
        select.selectByIndex(2);
        System.out.println(select.getFirstSelectedOption().getText());

        select.selectByVisibleText("Option 1");
        System.out.println(select.getFirstSelectedOption().getText());
        select.selectByVisibleText("Option 2");
        System.out.println(select.getFirstSelectedOption().getText());
    }

    @Test
    void checkbox() {
        driver.get("https://the-internet.herokuapp.com/checkboxes");

        //checkbox --> input
        WebElement checkbox1 = driver.findElement(check1);
        WebElement checkbox2 = driver.findElement(check2);

        Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofMillis(5000))
                .pollingEvery(Duration.ofMillis(100))
                .ignoring(NoSuchElementException.class);

        fluentWait.until(ExpectedConditions.elementToBeSelected(check1));

        if (checkbox1.isSelected()) {
            checkbox1.click();
        }
        if (checkbox2.isSelected()) {
            checkbox2.click();
        }
    }

    @Test
    void menuDinamico() {
        driver.navigate().to("https://the-internet.herokuapp.com/jqueryui/menu");

        WebElement btnEnabled = driver.findElement(btnEnabledLocator);
        WebElement btnDownload = driver.findElement(btnDownloadLocator);
        WebElement btnPDF = driver.findElement(btnPdfLocator);

        //espera explicita = espera asincrónica
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(3000));

        if (wait.until(ExpectedConditions.elementToBeSelected(btnPDF))) {
            btnDownload.click();
        }
        if (btnPDF.isDisplayed()) {
            btnPDF.click();
        }
        if (btnEnabled.isDisplayed()) {
            btnEnabled.click();
            //Thread.sleep(500);
            btnDownload.click();
            //Thread.sleep(500);
            btnPDF.click();
        }
    }

    @Test
    void iframes(){
        driver.navigate().to("https://the-internet.herokuapp.com/tinymce");

        //trae todos los iframes de la pagina
        List<WebElement> iframes = driver.findElements(By.tagName("iframe"));
        System.out.println(iframes);

        driver.switchTo().frame(iframes.get(0));
        WebElement iframeTextElement = driver.findElement(iframeText);
        iframeTextElement.clear();
        iframeTextElement.sendKeys("Hola estoy enviando informacion desde el drive");

    }
    @Test
    void webTables() {
        driver.navigate().to("https://the-internet.herokuapp.com/tables");

        //trae todos los elementos de la tabla
        List<WebElement> webTable = driver.findElements(By.id("table1"));

        //cuantas columnas tiene el web table?
        List<WebElement> columnas = webTable.get(0).findElement(By.tagName("thead")).findElements(By.tagName("th"));
        System.out.println(columnas.size());

        for (WebElement th : columnas) {
            String text = th.getText();
            if (text.contains("Due")) {
                th.click();
                th.click();
                break;
            }
        }

        //obtener filas Web table
        List<WebElement> filas = webTable.get(0).findElement(By.tagName("tbody")).findElements(By.tagName("tr"));

        //obtener data de la primera fila
        String nombre = filas.get(0).findElement(By.xpath("td[2]")).getText();
        String apellido = filas.get(0).findElement(By.xpath("td[1]")).getText();
        String deuda = filas.get(0).findElement(By.xpath("td[4]")).getText();

        System.out.println("La persona con mayor deuda es: " + nombre + " " + apellido + " " + deuda);

    }

    @Test
    void webtables2() {
        driver.navigate().to("https://the-internet.herokuapp.com/tables");

        //ejemplo de fila 2: ordenar (hacer doble click) y buscar los apellidos de los usuarios deudores en loop
        List<WebElement> webTable2 = driver.findElements(By.id("table2"));

        List<WebElement> columnas2 = webTable2.get(0).findElement(By.tagName("thead")).findElements(By.tagName("th"));

        for (WebElement th : columnas2) {
            String apellidos = th.getText();
            if (apellidos.contains("Last Name")) {
                th.click();
            }
        }

        List<WebElement> filas2 = webTable2.get(0).findElement(By.tagName("tbody")).findElements(By.tagName("tr"));

        System.out.println("---------------DEUDORES--------------");
        for (int i=0; i< filas2.size();i++) {
            String apellidoDeudores = filas2.get(i).findElement(By.xpath("td[1]")).getText();
            String nombreDeudores = filas2.get(i).findElement(By.xpath("td[2]")).getText();
            System.out.println(apellidoDeudores + " " + nombreDeudores);
        }
    }

    @AfterEach
    void close(){
        driver.quit();
    }
}
