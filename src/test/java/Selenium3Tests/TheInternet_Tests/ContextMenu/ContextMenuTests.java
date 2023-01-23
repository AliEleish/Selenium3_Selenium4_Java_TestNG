package Selenium3Tests.TheInternet_Tests.ContextMenu;

import Selenium3Tests.TheInternet_Tests.Base.TheInternetSelenium3WebTestBase;
import Selenium3.TheInternet.Pages.ContextMenuPage;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class ContextMenuTests extends TheInternetSelenium3WebTestBase {

    @Test
    public void testContextMenuRightClick(){
        ContextMenuPage contextMenuPageObj = homePageObj.clickContextMenuLink();
        contextMenuPageObj.contextMenuBox_RightClick();
        assertEquals(contextMenuPageObj.alert_GetText(),"You selected a context menu" , "Context Menu alert text is incorrect");
        contextMenuPageObj.alert_Accept();
    }
}
