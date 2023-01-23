package Selenium3.TheInternet.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class JS_AlertsPage {

    private WebDriver driver;
    private By triggerAlertButton = By.xpath("//button[text() ='Click for JS Alert']");
    private By triggerConfirmButton = By.xpath("//button[text() ='Click for JS Confirm']");
    private By triggerPromptButton = By.xpath("//button[text() ='Click for JS Prompt']");
    private By resultsMessage = By.id("result");

    public JS_AlertsPage(WebDriver driver){
        this.driver = driver;
    }

    public void clickAlertButton(){
        driver.findElement(triggerAlertButton).click();
    }
    public void  clickConfirmButton(){
        driver.findElement(triggerConfirmButton).click();
    }
    public void clickPromptButton(){
        driver.findElement(triggerPromptButton).click();
    }
    public void alert_clickToAccept(){
        driver.switchTo().alert().accept();
    }
    public String alertGetText(){
        return  driver.switchTo().alert().getText();
    }
    public void alert_ClickToDismiss(){
        driver.switchTo().alert().dismiss();
    }
    public void alert_EnterText(String text){
        driver.switchTo().alert().sendKeys(text);
    }
    public String getTextFromResultsMessage(){
        return driver.findElement(resultsMessage).getText();
    }


}
