package Selenium4.TheInternet.Pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v85.log.Log;
import org.openqa.selenium.edge.EdgeDriver;

public class BrokenImagesPage {

    private WebDriver driver;

    public BrokenImagesPage(WebDriver driver){
        this.driver = driver;
    }

    public void getConsoleLogsOnChrome(){

        DevTools chromeDevTools = ((ChromeDriver)driver).getDevTools();
        chromeDevTools.createSession();

        chromeDevTools.send(Log.enable());
        chromeDevTools.addListener(Log.entryAdded() , logEntry -> {
            System.out.println("----------");
            System.out.println("Text: " + logEntry.getText());
            System.out.println("Level: " + logEntry.getLevel());
            System.out.println("Broken URLs: " + logEntry.getUrl());

        });
        driver.get("https://the-internet.herokuapp.com/broken_images");
    }
}
