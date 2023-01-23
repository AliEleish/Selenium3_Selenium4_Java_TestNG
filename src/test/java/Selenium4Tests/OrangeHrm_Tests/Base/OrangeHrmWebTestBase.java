package Selenium4Tests.OrangeHrm_Tests.Base;

import Selenium4.OrangeHrm.Pages.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class OrangeHrmWebTestBase {

    private WebDriver driver;
    protected LoginPage loginPageObj;

    @BeforeClass
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://opensource-demo.orangehrmlive.com/");
        loginPageObj = new LoginPage(driver);
    }

    @AfterClass
    public void teatDown(){
        driver.quit();
    }
}
