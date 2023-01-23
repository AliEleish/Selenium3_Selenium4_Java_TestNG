package Selenium4Tests.TheInternet_Tests.ConsoleLogs;

import Selenium4Tests.TheInternet_Tests.Base.TheInternetSelenium4WebTestBase;
import org.testng.annotations.Test;

public class ConsoleLogsTests extends TheInternetSelenium4WebTestBase {


    @Test
    public void testConsoleLogsOnChrome()
    {
        brokenImagesPageObj.getConsoleLogsOnChrome();
    }
}
