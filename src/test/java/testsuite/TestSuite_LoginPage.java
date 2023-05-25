package testsuite;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import pageobject.LoginPage;

import java.util.concurrent.TimeUnit;

public class TestSuite_LoginPage {
    private WebDriver driver;

    @BeforeSuite
    public void initiateDriver(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        this.driver = driver;

        // setting up implicit wait
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }
    @Test
    public  void TC_001_validateSuccessfulLogin(){
        this.driver.get("https://www.tradeindia.com/login/login.html");
        LoginPage login_page = new LoginPage(driver);

        login_page.clickEmailLink();
        login_page.fillEmail("deep.mala@tradeindia.com");
        login_page.clickContinueSignInBtn();
        login_page.fillPassword("trade12india");
        login_page.clickLoginBtn();
    }

    @AfterSuite
    public void endDriver(){
        this.driver.quit();
    }
}
