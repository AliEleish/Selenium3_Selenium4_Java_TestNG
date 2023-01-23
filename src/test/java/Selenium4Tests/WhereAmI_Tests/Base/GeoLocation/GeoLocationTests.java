package Selenium4Tests.WhereAmI_Tests.Base.GeoLocation;

import Selenium4Tests.WhereAmI_Tests.Base.WhereAmIWebTestBase;
import org.testng.annotations.Test;

public class GeoLocationTests extends WhereAmIWebTestBase {

    @Test
    public void testGeoLocation_executeCdpCommand(){
        homePageObj.setGeoLocation_executeCdpCommand();
    }

    @Test
    public void testGeoLocation_DevTools(){
        homePageObj.setGeoLocation_DevTools();
    }
}
