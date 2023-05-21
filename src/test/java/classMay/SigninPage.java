package classMay;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SigninPage {
    private WebDriver driver;
    @FindBy(id="email")
    WebElement email;
    @FindBy(id="password")
    WebElement password;
    @FindBy(xpath="//*[@id=\"js_btn_login\"]/span")
    WebElement signIn;
    public SigninPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
    public SigninPage email(String email){
        this.email.sendKeys(email);
        return this;
    }
    public SigninPage password(String password){
        this.password.sendKeys(password);
        return this;
    }
    public void clickOnSignInButton(){
        this.signIn.click();
    }


}
