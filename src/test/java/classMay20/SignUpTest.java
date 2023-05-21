package classMay20;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import webDriver.WebDriverManagerClass;

public class SignUpTest {
    WebDriver driver;
    ZoomNavBar navBar;
    @BeforeSuite
    public void setUp(){
        driver= WebDriverManagerClass.getDriver();
        driver.get("https://zoom.us");
        navBar=new ZoomNavBar(driver);
        driver.manage().window().maximize();
    }
    @Test
    public void SignUpFreeTest(){

        navBar.signUpFreeClick();
    }
    @Test
    public void virtualMeetingsTest(){
        navBar.productsClick();
    }

    @Test
    public void zoomSignUpTest(){
        ZoomSignUp signUp=new ZoomSignUp(driver);
        signUp.birthYear.sendKeys("1984");

    }
    @AfterSuite
    public void tearDown() throws InterruptedException {
        Thread.sleep(5000);
        driver.quit();
    }
}
