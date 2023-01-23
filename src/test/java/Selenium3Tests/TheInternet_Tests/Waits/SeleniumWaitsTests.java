package Selenium3Tests.TheInternet_Tests.Waits;

import Selenium3Tests.TheInternet_Tests.Base.TheInternetSelenium3WebTestBase;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class SeleniumWaitsTests extends TheInternetSelenium3WebTestBase {

    @Test
    public void testExample1PageWithExplicitWait(){

        var example1DynamicLoadedPageObj = homePageObj.clickDynamicLoadingLink().clickExample1Link();
        example1DynamicLoadedPageObj.clickStartButtonWithExplicitWait();
        assertEquals(example1DynamicLoadedPageObj.getResultMessageText() , "Hello World!" , "The result message is incorrect");
    }
    @Test
    public void testExample1PageWithFluentWait(){

        var example1DynamicLoadedPageObj = homePageObj.clickDynamicLoadingLink().clickExample1Link();
        example1DynamicLoadedPageObj.clickStartButtonWithFluentWait();
        assertEquals(example1DynamicLoadedPageObj.getResultMessageText() , "Hello World!"
                , "The result message is incorrect");
    }

    @Test
    public void testExample2PageWithExplicitWait(){
        var example2DynamicLoadedPageObj = homePageObj.clickDynamicLoadingLink().clickExample2Link();
        example2DynamicLoadedPageObj.clickStartButtonWithExplicitWait();
        assertEquals(example2DynamicLoadedPageObj.getResultMessageText(),"Hello World!" ,"The result message is incorrect" );
    }
    @Test
    public void testExample2PageWithFluentWait(){
        var example2DynamicLoadedPageObj = homePageObj.clickDynamicLoadingLink().clickExample2Link();
        example2DynamicLoadedPageObj.clickStartButtonWithFluentWait();
        assertEquals(example2DynamicLoadedPageObj.getResultMessageText(),"Hello World!" ,"The result message is incorrect" );
    }
}
