import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;

public class StartsSet {
    @BeforeAll
    static void beforeAll() {
        Configuration.remote = "https://user1:1234@selenoid.autotests.cloud/wd/hub";
        //Configuration.holdBrowserOpen = true;
        Configuration.browserSize = "720x800";
        SelenideLogger.addListener("allure", new AllureSelenide());
    }
}
