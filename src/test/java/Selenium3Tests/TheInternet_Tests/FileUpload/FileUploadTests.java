package Selenium3Tests.TheInternet_Tests.FileUpload;

import Selenium3Tests.TheInternet_Tests.Base.TheInternetSelenium3WebTestBase;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class FileUploadTests extends TheInternetSelenium3WebTestBase {

    @Test
    public void test_SuccessfulFileUpload(){
        var fileUploadPageObj = homePageObj.clickFileUploadLink();
        var fileUploadedPageObj = fileUploadPageObj.uploadFile("C:\\Users\\DELL\\Documents\\MyCVs\\Ali Eleish.pdf");
        assertEquals (fileUploadedPageObj.getTextFromUploadedFileResultMessage(), "Ali Eleish.pdf" ,
                "The text of uploaded file is incorrect" );
    }
}
