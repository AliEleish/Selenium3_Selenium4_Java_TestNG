package Selenium3Tests.TheInternet_Tests.Login;

import Selenium3Tests.TheInternet_Tests.Base.TheInternetSelenium3WebTestBase;
import Selenium3.TheInternet.Pages.LoginPage;
import Selenium3.TheInternet.Pages.SecureAreaPage;
import org.testng.annotations.Test;
import static org.testng.Assert.assertTrue;

public class LoginTests extends TheInternetSelenium3WebTestBase {

    @Test
    public void testSuccessfulLogin(){
       LoginPage loginPageObj = homePageObj.clickFormAuthenticationLink();
       loginPageObj.enterUsername("tomsmith");
       loginPageObj.enterPassword("SuperSecretPassword!");
       SecureAreaPage secureAreaPageObj = loginPageObj.clickLoginButton();
       assertTrue(secureAreaPageObj.getSuccessLoginMessage().contains("You logged into a secure area!"),
               "The successful login message is incorrect ");
    }
}
