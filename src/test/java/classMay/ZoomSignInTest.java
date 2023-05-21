package classMay;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import webDriver.WebDriverManagerClass;

public class ZoomSignInTest {
    WebDriver driver;
    @BeforeSuite
    public void setUp(){
        driver= WebDriverManagerClass.getDriver();
        driver.get("https://zoom.us/");
    }
    @Test
    public void signInTest(){
     TopNavBar navBar=new TopNavBar(driver);
     navBar.hostSignIn.click();
     SigninPage signIn=new SigninPage(driver);
     signIn.email("gurpreet@gmail.com").password("hello12345").clickOnSignInButton();
    }
    @Test
    public void screenShareTest(){
        TopNavBar navBar=new TopNavBar(driver);
        //navBar.join.click();
        //navBar.host.click();
        navBar.clickOnScreenShare();
    }
    @AfterSuite
    public void tearDown() throws InterruptedException {
        Thread.sleep(5000);
        driver.quit();
    }
}
