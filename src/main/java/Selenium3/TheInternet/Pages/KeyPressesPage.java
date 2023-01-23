package Selenium3.TheInternet.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class KeyPressesPage {

    private WebDriver driver;
    private By inputTxtField = By.id("target");
    private By inputResultMessage = By.id("result");

    public KeyPressesPage(WebDriver driver){
        this.driver = driver;
    }

    public void enterText(String text){
        driver.findElement(inputTxtField).sendKeys(text);
    }

    /**
     * This method used to test pressing more than 1 keyboard key at the same time using Keys.chord(String CharSequence)
     * */
    public void enterSalary(String salary){
        enterText("Salary is " + Keys.chord(Keys.SHIFT + "4") + salary);
    }

    public String getText(){
        return driver.findElement(inputResultMessage).getText();
    }

}
