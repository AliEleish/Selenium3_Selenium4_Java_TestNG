package Selenium3.TheInternet.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class DropDownPage {

    private WebDriver driver;
    Select dropDown;
    public DropDownPage(WebDriver driver){
        this.driver = driver;
    }

    /**
     * @param  selectorType : is the way to select an option from a dropdown by VisibleText or valur attribute or index
     * @param  selectorValue : is the value of the @selectorType we used to select the element from a dropdown
     * */
    public void selectFromDropDown(String selectorType , String selectorValue){
         dropDown = findDropDown();

        if (selectorType.equalsIgnoreCase("visibleText")){
            dropDown.selectByVisibleText(selectorValue);
        }
        else if (selectorType.equalsIgnoreCase("value")){
            dropDown.selectByValue(selectorValue);
        }

        else if (selectorType.equalsIgnoreCase("index")){
            dropDown.selectByIndex(Integer.parseInt(selectorValue));
        }
    }
    public List<String> getSelectedOptionsFromDropDown(){
      List<String> selectedOptionsTexts = new ArrayList<>();
      dropDown.getAllSelectedOptions().stream().forEach(element -> selectedOptionsTexts.add(element.getText()));
      return selectedOptionsTexts;
    }

    public void setDropDownAllowMultipleSelections(){
        dropDown = findDropDown();
        String script = "arguments[0].setAttribute('multiple','');";
        JavascriptExecutor JSE = (JavascriptExecutor)driver;
        JSE.executeScript(script,dropDown);
    }

    private Select findDropDown(){
        return new Select(driver.findElement(By.id("dropdown")));
    }

}
