package Selenium4Tests.NetworkConditions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v85.network.Network;
import org.openqa.selenium.devtools.v85.network.model.ConnectionType;
import org.openqa.selenium.mobile.NetworkConnection;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Optional;

public class NetworkConditionsTests {

    private ChromeDriver driver;
    private DevTools chromeDevTools;

    @BeforeMethod
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void testSlowNetworkGoogle(){

        chromeDevTools = driver.getDevTools();
        chromeDevTools.createSession();

        chromeDevTools.send(Network.enable(Optional.empty(),
                Optional.empty() , Optional.empty()));

        chromeDevTools.send(Network.emulateNetworkConditions(false , 150 , 2500 , 2500
        , Optional.of(ConnectionType.CELLULAR3G)));

        driver.get("https://www.google.com/");
        System.out.println("Enable Network Conditions " + driver.getTitle());
    }

    @Test
    public void testDisableNetworkConditionsGoogle(){
        driver.get("https://www.google.com/");
        System.out.println("Disable Network Conditions " + driver.getTitle());
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
