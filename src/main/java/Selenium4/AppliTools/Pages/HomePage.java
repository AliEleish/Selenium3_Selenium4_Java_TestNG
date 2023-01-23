package Selenium4.AppliTools.Pages;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class HomePage {

    private WebDriver driver;
    private WebDriverWait wait;
    private By testAutomationFrameworkBy = By.cssSelector("#post-8 h1");
    private By testAutomationFrameworkPageSectionBy = By.xpath("(//div[@class = 'container']/div)[2]");
    private By headerImg = By.cssSelector(".header-image>img");

    public HomePage(WebDriver driver){
        this.driver = driver;
    }

    public void takeScreenshotWebElement() throws IOException {
        WebElement testAutomationFramework = driver.findElement(testAutomationFrameworkBy);
        File source = testAutomationFramework.getScreenshotAs(OutputType.FILE);
        File destination = new File("src/main/resources/AppliToolsScreenshots/screenshots/testAutomationFramework.png");
        FileHandler.copy(source,destination);
    }

    public void takeScreenshotPageSection() throws IOException {
        waitForElementExplicitly(headerImg);
        WebElement testAutomationFrameworkPageSection = driver.findElement(testAutomationFrameworkPageSectionBy);
        File source = testAutomationFrameworkPageSection.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(source
                , new File("src/main/resources/AppliToolsScreenshots/screenshots/testAutomationFrameworkPageSection.png"));
    }

    public void takeScreenshotFullPage() throws IOException {
        File source = ((FirefoxDriver)driver).getFullPageScreenshotAs(OutputType.FILE);
        FileHandler.copy(source ,
                new File("src/main/resources/AppliToolsScreenshots/screenshots/AppliToolsFullPageScreenshot.png"));
    }

    private void waitForElementExplicitly(By by){
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }


}
