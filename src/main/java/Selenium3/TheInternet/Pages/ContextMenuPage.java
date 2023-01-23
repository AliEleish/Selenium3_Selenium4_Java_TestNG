package Selenium3.TheInternet.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class ContextMenuPage {

    private WebDriver driver;
    private By contextMenuBox = By.id("hot-spot");

    public ContextMenuPage(WebDriver driver){
        this.driver = driver;
    }

    public void contextMenuBox_RightClick(){
        Actions actions = new Actions(driver);
        actions.contextClick(driver.findElement(contextMenuBox)).perform();

    }

    public String alert_GetText(){
        return driver.switchTo().alert().getText();
    }

    public void alert_Accept(){
        driver.switchTo().alert().accept();
    }

}
