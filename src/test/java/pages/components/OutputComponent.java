package pages.components;

import com.codeborne.selenide.*;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class OutputComponent {
    private final SelenideElement outputElement = $("#output");

    public void checkResult(String key, String value) {
        outputElement.$("#" + key).shouldHave(text(value));
    }
}
