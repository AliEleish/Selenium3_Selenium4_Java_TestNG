package Selenium3Tests.TheInternet_Tests.KeyPresses;

import Selenium3Tests.TheInternet_Tests.Base.TheInternetSelenium3WebTestBase;
import Selenium3.TheInternet.Pages.KeyPressesPage;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class KeyPressesTests  extends TheInternetSelenium3WebTestBase {

    KeyPressesPage keyPressesPageObj;

    @Test
    public void testTABKeyPress(){
        keyPressesPageObj = homePageObj.clickKeyPressesLink();
        keyPressesPageObj.enterText("D" + Keys.TAB);
        assertEquals(keyPressesPageObj.getText() , "You entered: TAB");
    }

    @Test
    public void testConcurrentKeyPresses(){
        keyPressesPageObj = homePageObj.clickKeyPressesLink();
        keyPressesPageObj.enterSalary("5000");
    }
}
