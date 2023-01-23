package Selenium3.TheInternet.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Example1DynamicLoadedPage {

    private WebDriver driver;
    private  By startButton = By.cssSelector("#start button");
    private  By loadingBar = By.id("loading");
    private  By ResultMessage = By.cssSelector("#finish h4");
    private WebDriverWait wait;
    private FluentWait fluentWait;
    public Example1DynamicLoadedPage(WebDriver driver){
        this.driver = driver;
    }

    public void clickStartButtonWithExplicitWait(){
        driver.findElement(startButton).click();
        wait = new WebDriverWait(driver , Duration.ofSeconds(10));
        wait.until(ExpectedConditions.invisibilityOf(driver.findElement(loadingBar)));
    }

    public void clickStartButtonWithFluentWait(){
        driver.findElement(startButton).click();
        fluentWait = new FluentWait(driver).withTimeout(Duration.ofSeconds(10)).pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class);
        fluentWait.until(ExpectedConditions.invisibilityOf(driver.findElement(loadingBar)));
    }

    public String getResultMessageText(){
        return driver.findElement(ResultMessage).getText();
    }


}
