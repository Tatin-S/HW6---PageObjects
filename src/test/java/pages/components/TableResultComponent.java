package pages.components;

import com.codeborne.selenide.*;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class TableResultComponent {
    private final SelenideElement tableElement = $(".table-responsive");

    public void checkResultInTable(String key, String value) {
        tableElement.$(byText(key)).parent()
                .shouldHave(text(value));
    }
}
