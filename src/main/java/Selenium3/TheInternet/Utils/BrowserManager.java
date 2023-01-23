package Selenium3.TheInternet.Utils;

import org.openqa.selenium.WebDriver;

public class BrowserManager {

    private WebDriver driver;
    private WebDriver.Navigation navigate;

    public BrowserManager(WebDriver driver){
        this.driver = driver;
        this.navigate = this.driver.navigate();
    }

    public void goBack(){
        navigate.back();
    }

    public void goForward(){
        navigate.forward();
    }

    public void reloadPage(){
        navigate.refresh();
    }

    public void navigateToURL(String path){
        navigate.to(path);
    }
}
