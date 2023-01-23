package Selenium4Tests.TheInternet_Tests.Base;

import Selenium4.TheInternet.Pages.BrokenImagesPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v85.log.Log;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class TheInternetSelenium4WebTestBase {

    private WebDriver driver;
    protected BrokenImagesPage brokenImagesPageObj;

    @BeforeClass
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        brokenImagesPageObj = new BrokenImagesPage(driver);
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}
