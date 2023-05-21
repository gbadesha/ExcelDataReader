package zoomTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class ZoomTestSauceLab {
    RemoteWebDriver driver;
    @BeforeSuite
    public void setUp() throws MalformedURLException {
        ChromeOptions browserOptions = new ChromeOptions();
        browserOptions.setPlatformName("Windows 10");
        browserOptions.setBrowserVersion("latest");
        Map<String, Object> sauceOptions = new HashMap<>();
        sauceOptions.put("build", "<your build id>");
        sauceOptions.put("name", "<your test name>");
        browserOptions.setCapability("sauce:options", sauceOptions);

        URL url = new URL("https://oauth-gurpreetmba-43736:132ecb01-c602-49a4-96dd-a667daea64a8@ondemand.us-west-1.saucelabs.com:443/wd/hub");
        driver = new RemoteWebDriver(url, browserOptions);
        driver.get("https://explore.zoom.us/en/contactsales/");
         }
    @Test(priority = 1)
    public void zoomTestCanada() throws InterruptedException {
        WebElement email=driver.findElement(By.id("email"));
        WebElement  cName=driver.findElement(By.id("company"));
        WebElement fName=driver.findElement(By.id("first_name"));
        WebElement lName=driver.findElement(By.id("last_name"));
        WebElement empCount=driver.findElement(By.id("employee_count"));
        WebElement phone=driver.findElement(By.id("phone"));
        WebElement country=driver.findElement(By.id("country"));
        WebElement state=driver.findElement(By.id("state"));
        WebElement zip=driver.findElement(By.id("city"));
        WebElement description=driver.findElement(By.id("description"));
        email.sendKeys("gurpreet@gmail.com");
        Thread.sleep(2000);
        cName.sendKeys("No company");
        Thread.sleep(2000);
        fName.sendKeys("Gurpreet");
        Thread.sleep(2000);
        lName.sendKeys("Singh");
        Thread.sleep(2000);
        phone.sendKeys("1234567890");
        Thread.sleep(2000);
        Select optionsEmpCount=new Select(empCount);
        optionsEmpCount.selectByValue("11-50");
        Thread.sleep(2000);
        Select optionsCountry=new Select(country);
        optionsCountry.selectByValue("CA");
        Thread.sleep(2000);
        Select optionsState=new Select(state);
        optionsState.selectByValue("ON");
        Thread.sleep(2000);
        zip.sendKeys("L6Y4H7");
        Thread.sleep(2000);
        description.sendKeys("i want to do Java Script");
        email.clear();
        cName.clear();
        fName.clear();
        lName.clear();
        phone.clear();
        zip.clear();
        description.clear();
    }
    @Test(dataProvider = "zoomDataIndia",dataProviderClass = zoomDataProvider.class,priority = 2)
    public void zoomContactTestIndia(String mail,String company,String firstName,String lastName,String mobile,String pin,String info) throws InterruptedException {
        WebElement email=driver.findElement(By.id("email"));
        WebElement  cName=driver.findElement(By.id("company"));
        WebElement fName=driver.findElement(By.id("first_name"));
        WebElement lName=driver.findElement(By.id("last_name"));
        WebElement empCount=driver.findElement(By.id("employee_count"));
        WebElement phone=driver.findElement(By.id("phone"));
        WebElement country=driver.findElement(By.id("country"));
        WebElement state=driver.findElement(By.id("state"));
        WebElement zip=driver.findElement(By.id("city"));
        WebElement description=driver.findElement(By.id("description"));
        email.sendKeys(mail);
        Thread.sleep(2000);
        cName.sendKeys(company);
        Thread.sleep(2000);
        fName.sendKeys(firstName);
        Thread.sleep(2000);
        lName.sendKeys(lastName);
        Thread.sleep(2000);
        phone.sendKeys(mobile);
        Thread.sleep(2000);
        Select optionsEmpCount=new Select(empCount);
        optionsEmpCount.selectByValue("51-250");
        Thread.sleep(2000);
        Select optionsCountry=new Select(country);
        optionsCountry.selectByValue("IN");
        Thread.sleep(2000);
        Select optionsState=new Select(state);
        optionsState.selectByValue("Punjab");
        Thread.sleep(2000);
        zip.sendKeys(pin);
        Thread.sleep(2000);
        description.sendKeys(info);
        email.clear();
        cName.clear();
        fName.clear();
        lName.clear();
        phone.clear();
        zip.clear();
        description.clear();
        //driver.findElement(By.xpath("/html/body/header/nav/div[2]/div/div/div[2]/div[1]/ul/li[1]/a")).clear();
    }
    @Test(dataProvider = "zoomDataUS",dataProviderClass = zoomDataProvider.class,priority = 3)
    public void zoomContactTestUS(String mail,String company,String firstName,String lastName,String mobile,String pin,String info) throws InterruptedException {
        WebElement email=driver.findElement(By.id("email"));
        WebElement  cName=driver.findElement(By.id("company"));
        WebElement fName=driver.findElement(By.id("first_name"));
        WebElement lName=driver.findElement(By.id("last_name"));
        WebElement empCount=driver.findElement(By.id("employee_count"));
        WebElement phone=driver.findElement(By.id("phone"));
        WebElement country=driver.findElement(By.id("country"));
        WebElement state=driver.findElement(By.id("state"));
        WebElement zip=driver.findElement(By.id("city"));
        WebElement description=driver.findElement(By.id("description"));
        email.sendKeys(mail);
        Thread.sleep(2000);
        cName.sendKeys(company);
        Thread.sleep(2000);
        fName.sendKeys(firstName);
        Thread.sleep(2000);
        lName.sendKeys(lastName);
        Thread.sleep(2000);
        phone.sendKeys(mobile);
        Thread.sleep(2000);
        Select optionsEmpCount=new Select(empCount);
        optionsEmpCount.selectByValue("251-500");
        Thread.sleep(2000);
        Select optionsCountry=new Select(country);
        optionsCountry.selectByValue("US");
        Thread.sleep(2000);
        Select optionsState=new Select(state);
        optionsState.selectByValue("NY");
        Thread.sleep(2000);
        zip.sendKeys(pin);
        Thread.sleep(2000);
        description.sendKeys(info);
        //driver.switchTo().frame(driver.findElement(By.id("iframe[1]")));
        //driver.findElement(By.className("FormStandard__fields")).clear();
        //driver.switchTo().parentFrame();
        //driver.findElement(By.xpath("/html/body")).clear();
    }
    @AfterMethod
    public void AfterMethod(){
        //driver.findElement(By.xpath("/html/body/header/nav/div[2]/div/div/div[2]/div[1]/ul/li[1]/a")).clear();
        //driver.findElement(By.className("ez__btnOutline")).clear();

    }
    @AfterSuite
    public void tearDown() throws InterruptedException {
        Thread.sleep(10000);
        driver.quit();

    }

}
