package Selenium3.TheInternet.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class HoversPage {
    private WebDriver driver;
    private By figureBy = By.className("figure");
    private By figureCaptionBy = By.className("figcaption");

    public HoversPage(WebDriver driver){
        this.driver = driver;
    }

    /**
     * @param index starts with 1
     * */
    public FigureCaption hoverOnFigure(int index){
       WebElement figure = driver.findElements(figureBy).get(index -1);
       Actions actions = new Actions(driver);
       actions.moveToElement(figure).perform();
       return new FigureCaption(figure.findElement(figureCaptionBy));

    }

    public class FigureCaption{
        private WebElement figureCaption;
        private By figureCaptionTitle = By.tagName("h5");
        private By figureCaptionLink  = By.tagName("a");

        FigureCaption(WebElement figureCaption){
            this.figureCaption = figureCaption;
        }

        public boolean figureCaptionTitleIsDisplayed(){
            return figureCaption.findElement(figureCaptionTitle).isDisplayed();
        }
        public String getFigureCaptionTitleText(){
            return figureCaption.findElement(figureCaptionTitle).getText();
        }

        public String getFigureCaptionLinkText(){
            return figureCaption.findElement(figureCaptionLink).getText();
        }


        public String getFigureCaptionLink(){
            return figureCaption.findElement(figureCaptionLink).getAttribute("href");
        }

    }
}
