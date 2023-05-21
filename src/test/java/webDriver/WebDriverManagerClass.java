package webDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverManagerClass {
    WebDriver driver;
    private static WebDriverManagerClass manager;
    public WebDriverManagerClass(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
    }
    public static WebDriver getDriver(){
        if(manager==null){
     manager=new WebDriverManagerClass();
        }
        return manager.driver;
    }
}
