package webElement;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import webDriver.WebDriverManagerClass;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class webElementTestInSauceLab {
    RemoteWebDriver driver;
    @BeforeSuite
    public void setUp() throws MalformedURLException {
        ChromeOptions browserOptions = new ChromeOptions();
        browserOptions.setPlatformName("Windows 10");
        browserOptions.setBrowserVersion("latest");
        Map<String, Object> sauceOptions = new HashMap<>();
        sauceOptions.put("build", "<Web Element>");
        sauceOptions.put("name", "<your test name>");
        browserOptions.setCapability("sauce:options", sauceOptions);

        URL url = new URL("https://oauth-gurpreetmba-43736:132ecb01-c602-49a4-96dd-a667daea64a8@ondemand.us-west-1.saucelabs.com:443/wd/hub");
        driver = new RemoteWebDriver(url, browserOptions);
        //driver= WebDriverManagerClass.getDriver();
        }
        @Test
        public void checkBoxTest() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/checkboxes");
        WebElement element=driver.findElement(By.xpath("/html/body/div[2]/div/div/form/input[1]"));
        if(element.isSelected()){
            System.out.println("Box is already checked");
        } else{
            Thread.sleep(2000);
            element.click();
            System.out.println("Now checkbox 1 is selected");
            }
        Thread.sleep(5000);
            driver.findElement(By.xpath("/html/body/div[2]/div/div/form/input[2]")).click();
            }
            @Test
            public void ContextMenuTest(){
        driver.navigate().to("https://the-internet.herokuapp.com/context_menu");
        driver.findElement(By.id("hot-spot"));
        Actions action=new Actions(driver);
        action.contextClick().build().perform();
        Alert alert = null;
                System.out.println(alert.getText());
            }
            @Test
            public void uiSelectTest(){ // where drop down options move with the mouse without click
        driver.navigate().to("https://www.cn.ca/en/");
        Actions action=new Actions(driver);
           action.moveToElement(driver.findElement(By.id("ctl06__130780e8900cb2a_repMainNav_topLevelLink_3")))
                .pause(Duration.ofSeconds(5))
                .moveToElement(driver.findElement(By.id("ctl06__130780e8900cb2a_repMainNav_repSecondLevel_3_secondLevelLink_1")))
                .pause(Duration.ofSeconds(5))
                .moveToElement(driver.findElement(By.id("ctl06__130780e8900cb2a_repMainNav_repSecondLevel_3_repThirdLevel_1_thirdLevelLink_1")))
                .pause(Duration.ofSeconds(5))
                .moveToElement(driver.findElement(By.id("ctl06__130780e8900cb2a_repMainNav_repSecondLevel_3_repThirdLevel_1_repFourthLevel_1_fourthLevelLink_0")))
                .click().build().perform();
            }
            @Test
            public void enableDisableElementTest() throws InterruptedException {
        driver.navigate().to("https://explore.zoom.us/en/contactsales/");
        WebElement element=driver.findElement(By.id("email"));
        //driver.
        //Actions action=new Actions(driver);
                ((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute('disabled','true')",element);
                       Thread.sleep(5000);
                       if(element.isEnabled()){
                           System.out.println("Element is enabled");
                       } else {
                           System.out.println("Element is disabled");
                       }

        }
        @AfterSuite
        public void tearDown() throws InterruptedException {
        Thread.sleep(5000);
        driver.quit();
        }
}
