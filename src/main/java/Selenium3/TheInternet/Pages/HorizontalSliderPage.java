package Selenium3.TheInternet.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class HorizontalSliderPage {

    private WebDriver driver;
    private By sliderContainerBy = By.className("sliderContainer");

    public HorizontalSliderPage(WebDriver driver){
        this.driver = driver;
    }

    public HorizontalSliderContainer findSliderContainer(){
        return new HorizontalSliderContainer(driver.findElement(sliderContainerBy));
    }

    public class HorizontalSliderContainer {
        private WebElement sliderContainer;
        private By sliderBy = By.tagName("input");
        private By sliderValueBy = By.tagName("span");
        WebElement slider;
        WebElement sliderValue;

        public HorizontalSliderContainer(WebElement sliderContainer){
            this.sliderContainer = sliderContainer;
        }

        public void moveSlider(String sliderVal){
            slider = sliderContainer.findElement(sliderBy);
            sliderValue = sliderContainer.findElement(sliderValueBy);
            Actions actions = new Actions(driver);
            actions.moveToElement(slider).perform();
            while(!sliderValue.getText().equals(sliderVal)) {
                slider.sendKeys(Keys.ARROW_RIGHT);
            }
        }
        public String getSliderValue(){
            return sliderValue.getText();
        }

    }

}
