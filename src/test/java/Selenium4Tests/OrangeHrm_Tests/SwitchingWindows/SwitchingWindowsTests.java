package Selenium4Tests.OrangeHrm_Tests.SwitchingWindows;

import Selenium4Tests.OrangeHrm_Tests.Base.OrangeHrmWebTestBase;
import org.testng.annotations.Test;

public class SwitchingWindowsTests extends OrangeHrmWebTestBase {

    @Test
    public void testSwitchingBetweenWindowTabs(){
        var forgotPasswordPageObj = loginPageObj.openForgotPasswordLinkInNewWindowTab();
        forgotPasswordPageObj.enterTextInUsernameTxtField("Admin");
        forgotPasswordPageObj.clickResetPasswordButton();
        var loginPageObj = forgotPasswordPageObj.getBackToLoginPageMainWindowTab();
        loginPageObj.login("Admin", "admin123");
    }
}
