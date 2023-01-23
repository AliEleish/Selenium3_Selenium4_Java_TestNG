package Selenium4Tests.WhereAmI_Tests.Base;

import Selenium4.WhereAmI.Pages.HomePage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

public class WhereAmIWebTestBase {

    private EdgeDriver driver;
    protected HomePage homePageObj;

    @BeforeClass
    public void setUp(){
        WebDriverManager.edgedriver().setup();
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        homePageObj = new HomePage(driver);
    }

    @AfterMethod
    public void goHome(){
        driver.get("https://where-am-i.org/");
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}
