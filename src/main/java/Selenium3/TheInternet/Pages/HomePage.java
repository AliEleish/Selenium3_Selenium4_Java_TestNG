package Selenium3.TheInternet.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

    private WebDriver driver;


    public HomePage(WebDriver driver){
        this.driver = driver;
    }

    public LoginPage clickFormAuthenticationLink(){

        clickLinkInHomePage("Form Authentication");
        return new LoginPage(driver);
    }

    public DropDownPage clickOnDropDownLink(){
        clickLinkInHomePage("Dropdown");
        return new DropDownPage(driver);

    }

    public HoversPage clickHoversLinks(){
        clickLinkInHomePage("Hovers");
        return new HoversPage(driver);
    }

    public KeyPressesPage clickKeyPressesLink(){
        clickLinkInHomePage("Key Presses");
        return new KeyPressesPage(driver);
    }
    public HorizontalSliderPage clickHorizontalSliderLink(){
        clickLinkInHomePage("Horizontal Slider");
        return new HorizontalSliderPage(driver);
    }

    public JS_AlertsPage clickJavaScriptAlertsLink(){
        clickLinkInHomePage("JavaScript Alerts");
        return new JS_AlertsPage(driver);
    }

    public FileUploadPage clickFileUploadLink(){
        clickLinkInHomePage("File Upload");
        return new FileUploadPage(driver);
    }

    public EntryAdPage clickEntryAdLink(){
        clickLinkInHomePage("Entry Ad");
        return new EntryAdPage(driver);
    }

    public ContextMenuPage clickContextMenuLink(){
       clickLinkInHomePage("Context Menu");
       return new ContextMenuPage(driver);
    }

    public WYSIWYGEditorPage clickWYSIWYGEditorLink(){
        clickLinkInHomePage("WYSIWYG Editor");
        return new WYSIWYGEditorPage(driver);
    }

    public FramesPage clickFramesLink(){
        clickLinkInHomePage("Frames");
        return new FramesPage(driver);
    }

    public DynamicLoadingPage clickDynamicLoadingLink(){
        clickLinkInHomePage("Dynamic Loading");
        return  new DynamicLoadingPage(driver);
    }

    public LargeAndDeepDomPage clickLargeDeepDomLink(){
        clickLinkInHomePage("Large & Deep DOM");
        return new LargeAndDeepDomPage(driver);
    }

    public InfiniteScrollPage clickInfiniteScrollLink(){
        clickLinkInHomePage("Infinite Scroll");
        return new InfiniteScrollPage(driver);
    }

    public MultipleWindowsPage clickMultipleWindowsLink(){
        clickLinkInHomePage("Multiple Windows");
        return new MultipleWindowsPage(driver);
    }

    private void clickLinkInHomePage(String linkText){
    driver.findElement(By.linkText(linkText)).click();
    }


}
