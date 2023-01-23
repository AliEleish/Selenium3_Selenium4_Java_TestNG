package Selenium3Tests.TheInternet_Tests.HorizontalSlider;

import Selenium3Tests.TheInternet_Tests.Base.TheInternetSelenium3WebTestBase;
import Selenium3.TheInternet.Pages.HorizontalSliderPage;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class HorizontalSliderTests extends TheInternetSelenium3WebTestBase {

     HorizontalSliderPage horizontalSliderPageObj;

    @Test
    public void testHorizontalSlider(){
        horizontalSliderPageObj = homePageObj.clickHorizontalSliderLink();
        HorizontalSliderPage.HorizontalSliderContainer horizontalSliderContainerObj =
                horizontalSliderPageObj.findSliderContainer();
        horizontalSliderContainerObj.moveSlider("4");
        assertEquals(horizontalSliderContainerObj.getSliderValue() , "4");

    }
}
