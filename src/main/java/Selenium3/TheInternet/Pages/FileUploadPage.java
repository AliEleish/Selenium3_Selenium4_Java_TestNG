package Selenium3.TheInternet.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FileUploadPage {

    private WebDriver driver;
    private By chooseFileButton = By.id("file-upload");
    private By uploadFileButton = By.id("file-submit");

    public FileUploadPage(WebDriver driver){
        this.driver = driver;
    }

    public FileUploadedPage uploadFile(String filepath){
        driver.findElement(chooseFileButton).sendKeys(filepath);
        clickUploadButton();
        return  new FileUploadedPage();
    }

    public void clickUploadButton(){
        driver.findElement(uploadFileButton).click();
    }

    public class FileUploadedPage{

        private  By uploadedFileResultMessage = By.id("uploaded-files");

        public String getTextFromUploadedFileResultMessage(){
            return  driver.findElement(uploadedFileResultMessage).getText();
        }
    }

}
