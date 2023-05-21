package classMay20;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class ZoomNavBar {
    WebDriver driver;
    @FindBy(xpath="//*[@id=\"mobileButtons\"]/li[2]/a")
    //@FindBy(id="mobileButtons")
    WebElement signUpFree;
    @FindBy(id="btnNewProducts")
    WebElement products;
    @FindBy(xpath="//*[@id=\"products\"]/div/div/div[1]/ul/li[1]/div/a")
    WebElement virtualMeetings;
    public ZoomNavBar(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
    public void signUpFreeClick(){
        this.signUpFree.click();
    }
    public void productsClick(){
        Actions actions=new Actions(driver);
        actions.moveToElement(this.products).click().build().perform();

                //moveToElement(this.virtualMeetings)
                //.click().build().perform();
    }

}
