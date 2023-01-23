package Selenium3Tests.TheInternet_Tests.Navigation;

import Selenium3Tests.TheInternet_Tests.Base.TheInternetSelenium3WebTestBase;
import Selenium3.TheInternet.Pages.DynamicLoadingPage;
import Selenium3.TheInternet.Pages.MultipleWindowsPage;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class NavigationTests extends TheInternetSelenium3WebTestBase {

     @Test
    public void testApplicationNavigation(){
         homePageObj.clickDynamicLoadingLink().clickExample2Link();
         var browserManagerObj = getBrowserManager();
         browserManagerObj.goBack();
         browserManagerObj.reloadPage();
         browserManagerObj.goForward();
         browserManagerObj.navigateToURL("https://www.facebook.com");
     }

     @Test
    public void testSwitchingBetweenBrowserTabs(){
          MultipleWindowsPage multipleWindowsPageObj = homePageObj.clickMultipleWindowsLink();
          multipleWindowsPageObj.clickOnClickHereLink();
          multipleWindowsPageObj.switchToTab("New Window");
     }

     @Test
    public void test_OpenExample2DynamicLoadedPageInNewWindow(){
        DynamicLoadingPage dynamicLoadingPageObj = homePageObj.clickDynamicLoadingLink();
        var example2DynamicLoadedPageObj = dynamicLoadingPageObj.openExample2PageInNewWindow();
         assertTrue(example2DynamicLoadedPageObj.verifyStartButtonVisibility());
     }
}
