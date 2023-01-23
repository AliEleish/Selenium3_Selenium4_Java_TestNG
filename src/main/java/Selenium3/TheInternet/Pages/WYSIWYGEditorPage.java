package Selenium3.TheInternet.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WYSIWYGEditorPage {

    private WebDriver driver;
    private By textArea = By.id("tinymce");
    private String frameId = "mce_0_ifr";
    private By increaeIndentionButton = By.xpath("(//button[@class = 'tox-tbtn'])[7]");

    public WYSIWYGEditorPage(WebDriver driver){
        this.driver = driver;
    }

    public void clearTextArea() throws InterruptedException {
        switchToFrame();
        Thread.sleep(3000);
        driver.findElement(textArea).clear();
        switchToMainContent();
    }

    public void setTextArea(String text){
        switchToFrame();
        driver.findElement(textArea).sendKeys(text);
        switchToMainContent();
    }

    public String getTextFromTextArea(){
        switchToFrame();
      String text = driver.findElement(textArea).getText();
      switchToMainContent();
      return text;
    }

    public void increaseIndention(){
        driver.findElement(increaeIndentionButton).click();
    }

    private void switchToFrame(){
        driver.switchTo().frame(frameId);
    }
    private void switchToMainContent(){
        driver.switchTo().parentFrame();
    }


}
