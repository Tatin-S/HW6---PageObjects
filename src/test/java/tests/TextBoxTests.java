package tests;

import org.junit.jupiter.api.*;
import pages.TextBoxPage;

public class TextBoxTests extends TestBase {

    TextBoxPage textBoxPage = new TextBoxPage();

    @Test
    void fillFormTest() {

        textBoxPage.openPage()
                .setUserName("Alex")
                .setUserEmail("alex@egorov.com")
                .setCurrentAddress("Some street 1")
                .setPermanentAddress("Another street 1")
                .submit()

                .checkResult("name", "Alex")
                .checkResult("email", "alex@egorov.com")
                .checkResult("currentAddress", "Some street 1")
                .checkResult("permanentAddress", "Another street 1");
    }
}