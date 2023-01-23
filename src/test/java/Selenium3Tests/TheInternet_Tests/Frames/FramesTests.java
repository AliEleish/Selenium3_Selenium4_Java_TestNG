package Selenium3Tests.TheInternet_Tests.Frames;

import Selenium3Tests.TheInternet_Tests.Base.TheInternetSelenium3WebTestBase;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class FramesTests extends TheInternetSelenium3WebTestBase {

    @Test
    public void testFramesTexts(){
      var framesPageObj =  homePageObj.clickFramesLink();
      framesPageObj.clickNestedFramesLink();
      assertTrue(framesPageObj.getTextFromLeftFrame().contains("LEFT"),"The Left Frame text is incorrect");
      assertTrue(framesPageObj.getTextFromBottomFrame().contains("BOTTOM"), "The Bottom Frame text is incorrect");
      assertTrue(framesPageObj.getTextFromRightFrame().contains("RIGHT"), "The Right Frame text is incorrect");
      assertTrue(framesPageObj.getTextFromMiddleFrame().contains("MIDDLE"), "The MIDDLE Frame text is incorrect");

    }
}
