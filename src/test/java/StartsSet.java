import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import helpers.Attach;
import org.openqa.selenium.remote.DesiredCapabilities;

public class StartsSet {
    @BeforeAll
    static void beforeAll() {

        //Configuration.holdBrowserOpen = true;


        Configuration.remote = System.getProperty("remoteUrl", "https://user1:1234@selenoid.autotests.cloud/wd/hub");
        SelenideLogger.addListener("allure", new AllureSelenide());

        Configuration.browserSize = System.getProperty("browserResolution", "720x800");
        String browserFullName = System.getProperty("browserFullName", "chrome:100");
        String[] splitName = browserFullName.split(":");
        Configuration.browser = splitName[0];
        Configuration.browserVersion = splitName[1];

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", true);
        Configuration.browserCapabilities = capabilities;
    }

    @AfterEach
    void addAttachment(){
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();
    }
}
