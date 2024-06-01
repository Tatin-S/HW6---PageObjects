package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import utils.TestData;
import helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.Map;

public class TestBase {
    TestData data;
    @BeforeAll
    static void beforeAll() {
        Configuration.pageLoadStrategy = "eager";
        Configuration.baseUrl=System.getProperty("baseUrl","https://demoqa.com");
        Configuration.browserSize=System.getProperty("browserSize","1920x1080");
        Configuration.browser=System.getProperty("browser","chrome");
        Configuration.browserVersion=System.getProperty("browserVersion","121");
        Configuration.remote = "https://user1:1234@" + System.getProperty("selenoidUrl", "selenoid.autotests.cloud") + "/wd/hub";

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("selenoid:options", Map.<String, Object>of(
                "enableVNC", true,
                "enableVideo", true
        ));
        Configuration.browserCapabilities = capabilities;
    }

    @AfterEach
    void afterEach() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();

        Selenide.closeWebDriver();
    }

    @BeforeEach
    void testDataGeneration()
    {
        data = new TestData();
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
    }
}