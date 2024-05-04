package pages;

import com.codeborne.selenide.*;
import static com.codeborne.selenide.Selenide.*;
import pages.components.OutputComponent;

public class TextBoxPage {

    private final SelenideElement userNameInput = $("#userName"),
            userEmailInput = $("#userEmail"),
            currentAddressInput = $("#currentAddress"),
            permanentAddressInput = $("#permanentAddress"),
            submit = $("#submit");

    OutputComponent outputComponent = new OutputComponent();

    public TextBoxPage openPage() {
        open("/text-box");

        return this;
    }

    public TextBoxPage setUserName(String value){
        userNameInput.setValue(value);

        return this;
    }

    public TextBoxPage setUserEmail(String value){
        userEmailInput.setValue(value);

        return this;
    }

    public TextBoxPage setCurrentAddress(String value){
        currentAddressInput.setValue(value);

        return this;
    }

    public TextBoxPage setPermanentAddress(String value){
        permanentAddressInput.setValue(value);

        return this;
    }
    public TextBoxPage submit(){
        submit.click();

        return this;
    }

    public TextBoxPage checkResult(String key, String value) {
        outputComponent.checkResult(key, value);

        return this;
    }
}