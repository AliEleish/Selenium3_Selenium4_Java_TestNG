package Selenium4.WhereAmI.Pages;

import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v85.emulation.Emulation;
import org.openqa.selenium.edge.EdgeDriver;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;


public class HomePage {

    private EdgeDriver driver;

    public HomePage(EdgeDriver driver){
        this.driver = driver;
    }

    public void setGeoLocation_executeCdpCommand(){
       Map coordinates = new HashMap()
        {{
            put("latitude" , 41.379131);
            put("longitude" , 2.120140);
            put("accuracy" , 1);
        }};
        driver.executeCdpCommand("Emulation.setGeolocationOverride" , coordinates );
    }

    public void setGeoLocation_DevTools(){
        DevTools edgeDevTools = driver.getDevTools();
        edgeDevTools.createSession();

        edgeDevTools.send(Emulation.setGeolocationOverride(Optional.of(41.379131),
                Optional.of(2.120140),
                Optional.of(1)));
    }
}
