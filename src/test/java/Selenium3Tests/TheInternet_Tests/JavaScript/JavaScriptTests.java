package Selenium3Tests.TheInternet_Tests.JavaScript;

import Selenium3Tests.TheInternet_Tests.Base.TheInternetSelenium3WebTestBase;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class JavaScriptTests extends TheInternetSelenium3WebTestBase {

    @Test
    public void testScrollToTableUsingJavascript(){
        var largeAndDeepDomPageObj = homePageObj.clickLargeDeepDomLink();
        largeAndDeepDomPageObj.scrollToTable();
    }

    @Test
    public void testScrollToParagraph(){
        homePageObj.clickInfiniteScrollLink().scrollToSpecificParagraph(5);
    }

    @Test
    public void testDropdownAllowsMultipleSelections(){
       var dropdownPageObj = homePageObj.clickOnDropDownLink();
       dropdownPageObj.setDropDownAllowMultipleSelections();
       dropdownPageObj.selectFromDropDown("value" , "1");
       dropdownPageObj.selectFromDropDown("value","2");
       assertEquals(dropdownPageObj.getSelectedOptionsFromDropDown().size() , 2
               , "The number of selected options in dropdown is incorrect");
       assertEquals(dropdownPageObj.getSelectedOptionsFromDropDown().get(0) , "Option 1");
        assertEquals(dropdownPageObj.getSelectedOptionsFromDropDown().get(1) , "Option 2");
    }
}
