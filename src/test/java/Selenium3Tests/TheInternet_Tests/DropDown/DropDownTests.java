package Selenium3Tests.TheInternet_Tests.DropDown;

import Selenium3Tests.TheInternet_Tests.Base.TheInternetSelenium3WebTestBase;
import Selenium3.TheInternet.Pages.DropDownPage;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class DropDownTests extends TheInternetSelenium3WebTestBase {

    private DropDownPage dropDownPageObj;

    @Test
    public void testSuccessfulOptionSelectionFromDropDown(){
        dropDownPageObj = homePageObj.clickOnDropDownLink();
        dropDownPageObj.selectFromDropDown("visibleText" , "Option 2");
        assertEquals(dropDownPageObj.getSelectedOptionsFromDropDown().size() , 1, "The Options size is incorrect");
        assertTrue(dropDownPageObj.getSelectedOptionsFromDropDown().get(0).equals("Option 2"));

    }
}
