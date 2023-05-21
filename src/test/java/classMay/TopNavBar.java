package classMay;

import org.apache.commons.compress.harmony.unpack200.bytecode.ByteCode;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TopNavBar {
    WebDriver driver;
    WebElement search;
    WebElement support;
    WebElement link888;
    WebElement demo;
@FindBy(xpath="//*[@id=\"black-topbar\"]/div/ul/li[6]/a")
    WebElement join;
@FindBy(xpath ="//*[@id=\"newBtnHostMeeting\"]")
WebElement host;
@FindBy(id="headerMenuHostVideoOFF")
    WebElement HostJoinWithVideo;
@FindBy(xpath = "//*[@id=\"hostMeetingDropdown\"]/li[2]/a")
    WebElement HostJoinWtoutVideo;
@FindBy(xpath="//*[@id=\"hostMeetingDropdown\"]/li[3]/a")
    WebElement hostLinkScreenShare;
    @FindBy(xpath = "//*[@id=\"black-topbar\"]/div/ul/li[8]/a")
    WebElement hostSignIn;
    public TopNavBar(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
       }
     public TopNavBar clickOnScreenShare(){
        Actions actions=new Actions(this.driver);
         WebDriverWait wait=new WebDriverWait(this.driver,Duration.ofSeconds(10));
         //wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"hostMeetingDropdown\"]/li[3]/a")));
         actions.moveToElement(this.host).click().pause(Duration.ofSeconds(5))
                .moveToElement(this.HostJoinWtoutVideo).click().build().perform();
    return new TopNavBar(driver);
    }
}
