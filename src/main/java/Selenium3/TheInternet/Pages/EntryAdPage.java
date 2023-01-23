package Selenium3.TheInternet.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class EntryAdPage {

    private WebDriver driver;
    private By modalBody = By.cssSelector(".modal-body p");
    private By modalCloseButton = By.cssSelector(".modal-footer p");

    public EntryAdPage(WebDriver driver){
        this.driver = driver;
    }

    public boolean verifyModalVisibility() throws InterruptedException {
        Thread.sleep(3000);
    return driver.findElement(modalBody).isDisplayed();
    }

    public String getModalBodyText(){
        return driver.findElement(modalBody).getText();
    }
    public void dismissModal(){
        driver.findElement(modalCloseButton).click();
    }
}
