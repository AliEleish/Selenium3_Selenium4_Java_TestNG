package Selenium3Tests.TheInternet_Tests.Base;

import Selenium3.TheInternet.Pages.HomePage;
import Selenium3.TheInternet.Utils.BrowserManager;
import com.google.common.io.Files;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.io.IOException;


/**
 * in case you want to listen on any of Selenium WebDriver events change the private WebDriver driver to
 * private EventFiringWebDriver driver;  And Copy the following code inside @BeforeClass Method
 *         driver =  new EventFiringWebDriver(new ChromeDriver());
 *         driver.register(new EventReporter());
 *         goHome();
 *         driver.manage().window().maximize();
 *         homePageObj = new HomePage(driver);
 * */
public class TheInternetSelenium3WebTestBase {

    private WebDriver driver;
    protected HomePage homePageObj;

    @BeforeClass
    public void setUp()  {
        driver =  new ChromeDriver(getChromeOptions());
        goHome();
        setCookie();
        driver.manage().window().maximize();

    }

    @BeforeMethod
    public void goHome(){
        driver.get("https://the-internet.herokuapp.com/");
        homePageObj = new HomePage(driver);
    }

    @AfterMethod
    public void takeScreenshot(ITestResult result){
        if (ITestResult.FAILURE == result.getStatus())
        {
            TakesScreenshot camera = (TakesScreenshot)driver;
            File screenShot = camera.getScreenshotAs(OutputType.FILE);
            try {
                Files.move(screenShot , new File("src/main/resources/screenshots/" + result.getName() + "Failure.png"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }

    public BrowserManager getBrowserManager(){
        return new BrowserManager(driver);
    }

    /**
     * This method is used to handle the browser extra options.
     * */
    private ChromeOptions getChromeOptions(){
        ChromeOptions options = new ChromeOptions();
        //options.addArguments("disable-infobars"); // used to disable the info bar , but it's no longer supported according to https://sqa.stackexchange.com/questions/32444/how-to-disable-infobar-from-chrome
        //options.setHeadless(true);   // used to run your test without launching the browser
        return options;
    }

    private void setCookie(){

        Cookie cookie = new Cookie.Builder("tau", "123")
                .domain("the-internet.herokuapp.com")
                .build();
        driver.manage().addCookie(cookie);
    }
}
