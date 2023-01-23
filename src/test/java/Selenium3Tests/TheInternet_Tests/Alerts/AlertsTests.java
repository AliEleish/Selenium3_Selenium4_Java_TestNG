package Selenium3Tests.TheInternet_Tests.Alerts;

import Selenium3Tests.TheInternet_Tests.Base.TheInternetSelenium3WebTestBase;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class AlertsTests extends TheInternetSelenium3WebTestBase {

    @Test
    public void testAlertAcceptance(){
        var JS_AlertsPageObj = homePageObj.clickJavaScriptAlertsLink();
        JS_AlertsPageObj.clickAlertButton();
        JS_AlertsPageObj.alert_clickToAccept();
        assertEquals(JS_AlertsPageObj.getTextFromResultsMessage() , "You successfully clicked an alert"
                , "Results Message text is incorrect");
    }

    @Test
    public void testGetTextAndDismissConfirmAlert(){
        var JS_AlertsPageObj = homePageObj.clickJavaScriptAlertsLink();
        JS_AlertsPageObj.clickConfirmButton();
        assertEquals(JS_AlertsPageObj.alertGetText(), "I am a JS Confirm" , "Alert Text is Incorrect");
        JS_AlertsPageObj.alert_ClickToDismiss();
        assertEquals(JS_AlertsPageObj.getTextFromResultsMessage() , "You clicked: Cancel"
                , "Results Message text is incorrect");
    }

    @Test
    public void testEnterTextInAlert(){
        var JS_AlertsPageObj = homePageObj.clickJavaScriptAlertsLink();
        JS_AlertsPageObj.clickPromptButton();
        JS_AlertsPageObj.alert_EnterText("Test entering text in a prompt alert");
        JS_AlertsPageObj.alert_clickToAccept();
        assertEquals(JS_AlertsPageObj.getTextFromResultsMessage(),"You entered: Test entering text in a prompt alert");
    }
}
