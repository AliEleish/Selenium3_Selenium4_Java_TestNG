package Selenium3.TheInternet.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class InfiniteScrollPage {

    private WebDriver driver;
    private By textBlocks = By.className("jscroll-added");

    public InfiniteScrollPage(WebDriver driver){
        this.driver = driver;
    }

    /**
     * Scrolls until paragraph specified is in view
     * @param  index : starts with 1
     * */
    public void scrollToSpecificParagraph(int index){
        String script = "window.scrollTo(0, document.body.scrollHeight);";
        var JSE = (JavascriptExecutor)driver;

        while(index != getNumberOfParagraphs()){
            JSE.executeScript(script);
        }
    }

    private int getNumberOfParagraphs(){
       return  driver.findElements(textBlocks).size();
    }
}
