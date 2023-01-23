package Selenium3.TheInternet.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.Set;


public class DynamicLoadingPage {

    private WebDriver driver;
    private String xpathTextFormat = ".//a[contains(text() , '%s')]";
    private By example1Link = By.xpath(String.format(xpathTextFormat , "Example 1"));
    private By example2Link = By.xpath(String.format(xpathTextFormat , "Example 2"));
    public DynamicLoadingPage(WebDriver driver){
        this.driver = driver;
    }
    private Actions actions;

    public Example1DynamicLoadedPage clickExample1Link(){
        driver.findElement(example1Link).click();
        return new Example1DynamicLoadedPage(driver);
    }

    public Example2DynamicLoadedPage clickExample2Link(){
        driver.findElement(example2Link).click();
        return new Example2DynamicLoadedPage(driver);
    }

    public Example2DynamicLoadedPage openExample2PageInNewWindow(){

        actions = new Actions(driver);
        actions.keyDown(Keys.LEFT_CONTROL).click(driver.findElement(example2Link)).perform();

       Set<String> windows = driver.getWindowHandles();

       for(String window : windows){
           driver.switchTo().window(window);
           if(driver.getCurrentUrl().contains("/dynamic_loading/2"))
               break;
           }
       return new Example2DynamicLoadedPage(driver);
       }

    }


