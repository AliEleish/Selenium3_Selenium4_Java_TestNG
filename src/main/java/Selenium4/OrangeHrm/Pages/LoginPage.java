package Selenium4.OrangeHrm.Pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static org.openqa.selenium.support.locators.RelativeLocator.with;


public class LoginPage {

    private WebDriver driver;
    private WebDriverWait wait;
    private By loginPageTitle = By.cssSelector("h5[class*= 'orangehrm-login-title']");
    private WebElement usernameCredential;
    private WebElement passwordCredential;
    private By footerBy = By.className("orangehrm-login-footer");
    private By usernameTxtField = By.name("username");
    private By passwordTxtField = By.name("password");
    private By loginButton = By.cssSelector("button[type='submit']");
    private By orangeHrmLogo = By.xpath("//div[@class = 'orangehrm-login-branding']//img");

    public LoginPage(WebDriver driver){
        this.driver = driver;
    }

    public String getUsernameUsingRelativeLocator(){
        waitElementExplicitly(loginPageTitle);
        usernameCredential = driver.findElement(RelativeLocator.with(By.xpath("//div[contains(@class , 'oxd-sheet--rounded')]/p[1]"))
                .below(loginPageTitle));
        System.out.println(usernameCredential.getText());
        return  usernameCredential.getText();
    }

    public String getPasswordUsingRelativeLocator(){
        waitElementExplicitly(loginPageTitle);
        passwordCredential = driver.findElement(RelativeLocator.with(By.xpath("//div[contains(@class , 'oxd-sheet--rounded')]/p[2]"))
               .below(usernameCredential));
        System.out.println(passwordCredential.getText());
        return  passwordCredential.getText();
    }

    public void getSocialMediaList(){
        waitElementExplicitly(footerBy);
        WebElement footer = driver.findElement(footerBy);
       List<WebElement> socialMediaApps = driver.findElements(with(By.xpath("//div[@class='orangehrm-login-footer-sm']/a"))
               .toLeftOf(footer));
       for (WebElement socialMediaApp : socialMediaApps){
           System.out.println(socialMediaApp.getAttribute("href"));
       }
    }

    public ForgotPasswordPage openForgotPasswordLinkInNewWindowTab(){
        driver.switchTo().newWindow(WindowType.TAB)
                .get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/requestPasswordResetCode");
        return new ForgotPasswordPage(driver);
    }
    public void login(String username , String password){
        enterTextInTxtField(usernameTxtField , username);
        enterTextInTxtField(passwordTxtField , password);
        clickLoginButton();
    }

    public void OrangeHrmLogoLocationDimension(){
        waitElementExplicitly(orangeHrmLogo);
      Rectangle orangeHrmRect = driver.findElement(orangeHrmLogo).getRect();
        System.out.println("x: " + orangeHrmRect.getX());
        System.out.println("y: " + orangeHrmRect.getY());
        System.out.println("width: " + orangeHrmRect.getWidth());
        System.out.println("height: " + orangeHrmRect.getHeight());
    }

    private void clickLoginButton(){
        driver.findElement(loginButton).click();
    }
    private void enterTextInTxtField(By by , String text)
    {
        driver.findElement(by).sendKeys(text);
    }


    private void waitElementExplicitly(By by){
        wait = new WebDriverWait(driver , Duration.ofSeconds(15));
        wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }
}
