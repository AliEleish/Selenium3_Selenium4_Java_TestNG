package Selenium3.TheInternet.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FramesPage {

    private WebDriver driver;


    public FramesPage(WebDriver driver){
        this.driver = driver;
    }

    public void clickNestedFramesLink(){
        clickLinkInFramesPage("Nested Frames");
    }

    public String getTextFromLeftFrame(){
        switchToTopFrame();
        switchToLeftFrame();
        String text = driver.findElement(By.tagName("body")).getText();
        for(int i = 0 ; i<2 ; i++){
        switchToMainContent();
        }
        return text;
    }
    public String getTextFromRightFrame(){
        switchToTopFrame();
        switchToRightFrame();
        String text = driver.findElement(By.tagName("body")).getText();
        for(int i = 0 ; i<2 ; i++){
            switchToMainContent();
        }
        return text;
    }

    public String getTextFromMiddleFrame(){
        switchToTopFrame();
        switchToMiddleFrame();
        String text = driver.findElement(By.tagName("body")).getText();
        for(int i = 0 ; i<2 ; i++){
            switchToMainContent();
        }
        return text;
    }

    public String getTextFromBottomFrame(){
        switchToBottomFrame();
        String text = driver.findElement(By.tagName("body")).getText();
        switchToMainContent();
        return text;
    }

    /**
     * used to switch to the top frame which holds the left , middle and right frames inside it.
     * */
    private void switchToTopFrame() {
        driver.switchTo().frame("frame-top");
    }

    /**
     * Should be called after switching to the Top frame first using @switchToTopFrame()
     * */
    private void switchToLeftFrame() {
        driver.switchTo().frame("frame-left");
    }
    /**
     * Should be called after switching to the Top frame first using @switchToTopFrame()
     * */
    private void switchToMiddleFrame() {
        driver.switchTo().frame("frame-middle");
    }
    /**
     * Should be called after switching to the Top frame first using @switchToTopFrame()
     * */
     private void switchToRightFrame(){
        driver.switchTo().frame("frame-right");
    }

    private void switchToBottomFrame(){
           driver.switchTo().frame("frame-bottom");
           }

    private void switchToMainContent(){
        driver.switchTo().parentFrame();
           }

    private void clickLinkInFramesPage(String linkText){
        driver.findElement(By.linkText(linkText)).click();
    }
}
