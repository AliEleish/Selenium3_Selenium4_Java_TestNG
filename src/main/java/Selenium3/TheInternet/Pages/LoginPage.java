package Selenium3.TheInternet.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    private WebDriver driver;
    private By usernameTxtField = By.id("username");
    private By passwordTxtField = By.id("password");
    private By loginButton = By.cssSelector("#login button");

    public LoginPage(WebDriver driver) {
    this.driver = driver;
    }

    public void enterUsername(String username){
        driver.findElement(usernameTxtField).sendKeys(username);
    }

    public void enterPassword(String password){
        driver.findElement(passwordTxtField).sendKeys(password);
    }

    public SecureAreaPage clickLoginButton(){
        driver.findElement(loginButton).click();
        return new SecureAreaPage(driver);
    }
}
