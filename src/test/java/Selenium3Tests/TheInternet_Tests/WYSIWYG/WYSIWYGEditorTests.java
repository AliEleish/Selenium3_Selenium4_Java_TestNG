package Selenium3Tests.TheInternet_Tests.WYSIWYG;

import Selenium3Tests.TheInternet_Tests.Base.TheInternetSelenium3WebTestBase;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class WYSIWYGEditorTests extends TheInternetSelenium3WebTestBase {

    @Test
    public void test_WYSIWYGEditor() throws InterruptedException {

        var editor = homePageObj.clickWYSIWYGEditorLink();
        editor.clearTextArea();

        String text1 = "hello ";
        String text2 = "world!";

        editor.setTextArea(text1);
        editor.increaseIndention();
        editor.setTextArea(text2);
        assertEquals(editor.getTextFromTextArea() , text1+text2,"The text in the text area is incorrect");
    }
}
