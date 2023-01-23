package Selenium3Tests.TheInternet_Tests.EntryAd;

import Selenium3Tests.TheInternet_Tests.Base.TheInternetSelenium3WebTestBase;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class EntryAdTests extends TheInternetSelenium3WebTestBase {

    @Test
    public void testModalPopUp() throws InterruptedException {
       var entryAdPageObj =  homePageObj.clickEntryAdLink();
       assertTrue(entryAdPageObj.verifyModalVisibility());
       assertEquals(entryAdPageObj.getModalBodyText() ,
               "It's commonly used to encourage a user to take an action (e.g., give their e-mail address to sign up for something or disable their ad blocker).");

       entryAdPageObj.dismissModal();
    }


}
