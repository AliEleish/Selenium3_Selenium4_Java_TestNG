package Selenium4Tests.AppliTools_Tests.Base;

import Selenium4.AppliTools.Pages.HomePage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public class AppliToolsWebTestBase {

    private WebDriver driver;
    protected HomePage homePageObj;

    @BeforeClass
    public void setUp(){
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        goHome();
        homePageObj = new HomePage(driver);
    }

    @BeforeMethod
    public void goHome(){
        driver.navigate().to("https://applitools.com/");
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}
