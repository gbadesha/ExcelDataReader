package classMay;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import webDriver.WebDriverManagerClass;

import java.time.Duration;

public class StringTest {
    WebDriver driver;
    @BeforeSuite
    public void setUp(){
        driver= WebDriverManagerClass.getDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));


    }
    @Test
    public void dynamicElementTest(){
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
        //driver.findElement(By.id("start")).click();
        driver.findElement(By.xpath("//*[@id=\"start\"]/button")).click();
        //WebElement element=driver.findElement(By.xpath("//*[@id=\"finish\"]/h4"));
        WebElement element=driver.findElement(By.id("finish"));
        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
        WebElement until = wait.until(ExpectedConditions.visibilityOf(element));
        Assert.assertEquals(until.getText(),"Hello World!");

    }
    @Test
    public void dynamicElement2Test(){
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
        driver.findElement(By.xpath("//*[@id=\"start\"]/button")).click();
        WebElement element=driver.findElement(By.id("finish"));
        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.textToBePresentInElement(element,"Hello World!"));
        //wait.until(ExpectedConditions.textToBePresentInElementLocated(By.id("finish"),"Hello World!"));
        Assert.assertEquals(element.getText(),"Hello World!");
    }
    @Test
    public void autheticationTest(){
        driver.navigate().to("https://the-internet.herokuapp.com/login");
        driver.findElement(By.id("username")).sendKeys("tomsmith");
        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
        driver.findElement(By.xpath("//*[@id=\"login\"]/button/i")).click();
    }
    @Test
    public void dynamicControlsAddRemoveTest() throws InterruptedException {
        driver.navigate().to("https://the-internet.herokuapp.com/dynamic_controls");
        WebElement element = driver.findElement(By.xpath("//*[@id=\"checkbox-example\"]/button"));
        element.click();
        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5),Duration.ofMillis(500));
        Boolean add = wait.until(ExpectedConditions.textToBe(By.xpath("//*[@id=\"checkbox-example\"]/button"), "Add"));
        if(add=true){
            element.click();
        }
        WebElement textBox=driver.findElement(By.xpath("//*[@id=\"input-example\"]/input"));
        WebElement enable = driver.findElement(By.xpath("//*[@id=\"input-example\"]/button"));
        enable.click();
        WebDriverWait waitForEnable=new WebDriverWait(driver,Duration.ofSeconds(10));
        Boolean disable =waitForEnable.until(ExpectedConditions.textToBe(By.xpath("//*[@id=\"input-example\"]/button"), "Disable"));
        Assert.assertTrue(disable);
        System.out.println(enable.getText());
        if(disable){
            textBox.sendKeys("This box is enabled now");
        }
        }
        @Test
        public void dynamicControlsEnableDisableTest() throws InterruptedException {
            driver.navigate().to("https://the-internet.herokuapp.com/dynamic_controls");
            WebElement element = driver.findElement(By.xpath("//*[@id=\"input-example\"]/button"));
            if (element.getText().equals("Enable")) {
                System.out.println(" We are disabling Text box");
                element.click();
                Thread.sleep(5000);
            } else {
                System.out.println("We are enabling Text box");
                element.click();
                //Thread.sleep(5000);
            }
        }


    @AfterSuite
    public void tearDown() throws InterruptedException {
        Thread.sleep(5000);
        driver.quit();
    }
}
