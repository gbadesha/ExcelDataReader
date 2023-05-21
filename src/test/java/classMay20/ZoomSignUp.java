package classMay20;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ZoomSignUp {
    WebDriver driver;
    @FindBy(id="year")
    WebElement birthYear;

    @FindBy(xpath="//*[@id=\"app\"]/div/div[2]/div/div/button/span")
    WebElement continueButton;
    public ZoomSignUp(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
    public void continueClick(){
        this.continueButton.click();
    }


}
