package Selenium3.TheInternet.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MultipleWindowsPage {

    private WebDriver driver;
    private By clickHereLink = By.cssSelector(".example a");

    public MultipleWindowsPage(WebDriver driver){
        this.driver = driver;
    }

    public void clickOnClickHereLink(){
        driver.findElement(clickHereLink).click();
    }

    public void switchToTab(String tabTitle){
        var windows = driver.getWindowHandles();

        System.out.println("The Number of opened Windows is " + windows.size());
        windows.forEach(System.out::println);

        for (String window : windows){
            driver.switchTo().window(window);
            System.out.println("The Current Browser opened tab is " + driver.getTitle());
            if (driver.getTitle().equals(tabTitle))
                break;
        }
    }
}
