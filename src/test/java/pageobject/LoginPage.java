package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private WebDriver driver;
    private By login_btn = By.xpath("//button[@data-testid='loginBtn']");
    private By email_txt = By.xpath("//input[@name='email']");
    private By email_link = By.xpath("//p[text()='Login With Email & Password']");
    private By password_txt = By.xpath("//input[@name='otp']");
    private By submit_login_btn = By.xpath("//button[@type='submit' and text()='Verify And Proceed']");
    public LoginPage(WebDriver driver){
        this.driver = driver;
    }
    public void fillEmail(String email){
        this.driver.findElement(this.email_txt).sendKeys(email);
    }
    public void fillPassword(String password){
        this.driver.findElement(this.password_txt).sendKeys(password);
    }
    public void clickEmailLink(){
        this.driver.findElement(this.email_link).click();
    }
    public void clickContinueSignInBtn(){
        this.driver.findElement(this.login_btn).click();
    }
    public void clickLoginBtn(){
        this.driver.findElement(this.submit_login_btn).click();
    }
}
