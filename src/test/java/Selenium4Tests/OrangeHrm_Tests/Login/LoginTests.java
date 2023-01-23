package Selenium4Tests.OrangeHrm_Tests.Login;

import Selenium4Tests.OrangeHrm_Tests.Base.OrangeHrmWebTestBase;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class LoginTests extends OrangeHrmWebTestBase {

    @Test
    public void test_GetUserCredentials(){
        assertEquals(loginPageObj.getUsernameUsingRelativeLocator(),"Username : Admin");
        assertEquals(loginPageObj.getPasswordUsingRelativeLocator(),"Password : admin123");
    }

    @Test
    public void test_SocialMediaApps(){
        loginPageObj.getSocialMediaList();
    }
}
