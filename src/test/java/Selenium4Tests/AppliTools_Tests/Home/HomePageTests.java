package Selenium4Tests.AppliTools_Tests.Home;

import Selenium4Tests.AppliTools_Tests.Base.AppliToolsWebTestBase;
import org.testng.annotations.Test;

import java.io.IOException;

public class HomePageTests extends AppliToolsWebTestBase {


    @Test
    public void testTakeScreenshotOfWebElement() throws IOException {

        homePageObj.takeScreenshotWebElement();
    }

    @Test
    public void testTakeScreenshotOfPageSection() throws IOException {
        homePageObj.takeScreenshotPageSection();
    }

    @Test
    public void testFullPageScreenshot() throws IOException {
        homePageObj.takeScreenshotFullPage();
    }
}
