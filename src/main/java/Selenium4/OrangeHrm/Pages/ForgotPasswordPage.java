package Selenium4.OrangeHrm.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

public class ForgotPasswordPage {

    private WebDriver driver;
    private By usernameTxtField = By.name("username");
    private By resetPasswordBtn = By.cssSelector("button[type='submit']");
    private WebDriverWait wait;


    public ForgotPasswordPage(WebDriver driver){
        this.driver = driver;
    }

    public void enterTextInUsernameTxtField(String username){
        wait = new WebDriverWait(driver , Duration.ofSeconds(15));
        wait.until(ExpectedConditions.presenceOfElementLocated(usernameTxtField));
        driver.findElement(usernameTxtField).sendKeys(username);
    }

    public void clickResetPasswordButton(){
        wait = new WebDriverWait(driver , Duration.ofSeconds(15));
        wait.until(ExpectedConditions.presenceOfElementLocated(resetPasswordBtn));
        driver.findElement(resetPasswordBtn).click();
    }

    public LoginPage getBackToLoginPageMainWindowTab(){
        Set<String> allWindowTabs = driver.getWindowHandles();
        Iterator<String> iterator = allWindowTabs.iterator();
        String loginPageWindowIDHandle = iterator.next();
        driver.switchTo().window(loginPageWindowIDHandle);
        System.out.println(driver.getCurrentUrl());
        return new  LoginPage(driver);

    }
}
