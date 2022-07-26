package aut.engine.selenium;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.net.MalformedURLException;

public class DriverFactory {

    public WebDriver driver;
    public static ThreadLocal<WebDriver> hiloLocal = new ThreadLocal<>();

    /**
     * inicializa el WebDriver segun la seleccion del browser
     * @param browser: edge | firefox
     * @return Webdriver
     */
    public WebDriver inicializarDriver(String browser){
        System.out.println("browser value is: "+browser);

        if(browser.equals("edge")){
            WebDriverManager.edgedriver().setup();
            hiloLocal.set(new EdgeDriver());
        }else if(browser.equals("firefox")){
            WebDriverManager.firefoxdriver().setup();
            hiloLocal.set(new FirefoxDriver());
        }else {
            System.out.println("Please pass the correct browser value: "+browser);
        }
        getDriver().manage().deleteAllCookies();
        getDriver().manage().window().maximize();
        return getDriver();
    }



    /**
     * retorna el WebDriver desde el ThreadLocal
     * @return WebDriver
     */
    public static synchronized WebDriver getDriver(){
        return hiloLocal.get();
    }
}