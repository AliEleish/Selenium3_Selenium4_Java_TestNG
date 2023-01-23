package Selenium3Tests.TheInternet_Tests.Hovers;

import Selenium3Tests.TheInternet_Tests.Base.TheInternetSelenium3WebTestBase;
import Selenium3.TheInternet.Pages.HoversPage;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class HoversTests  extends TheInternetSelenium3WebTestBase {

    @Test
    public void testHoveringOverFigure(){
        HoversPage hoversPageObj = homePageObj.clickHoversLinks();
        HoversPage.FigureCaption figureCaptionObj = hoversPageObj.hoverOnFigure(2);
        assertTrue(figureCaptionObj.figureCaptionTitleIsDisplayed(),"Figure Caption Title is not displayed");
        assertEquals(figureCaptionObj.getFigureCaptionTitleText() , "name: user2"
                , "FigureCaption Title is incorrect");
        assertEquals(figureCaptionObj.getFigureCaptionLinkText(),"View profile"
                , "Figure Caption Link Text Is Incorrect");
        assertTrue(figureCaptionObj.getFigureCaptionLink().endsWith("/users/2"));
    }
}
