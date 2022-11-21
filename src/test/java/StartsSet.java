import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;

public class StartsSet {
    @BeforeAll
    static void beforeAll() {
        Configuration.holdBrowserOpen = true;
        Configuration.browserSize = "720x800";
    }
}
