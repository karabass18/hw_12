import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class tests_of_form {
@Test
    void fillFormTest() {
        Configuration.holdBrowserOpen= true;
        Configuration.browserSize = "1920x1080";
        open("https://demoqa.com/automation-practice-form");
        $("#firstName").setValue("Vania");
        $("#lastName").setValue("Ivanov");
        $("#userEmail").setValue("vania@vania.com");
        $("#gender-radio-3").doubleClick();

        $("#userNumber").setValue("1234567890");
        $("#dateOfBirthInput").click();
        $("[aria-label=\"Choose Thursday, November 10th, 2022\"]").click();
        $("#subjectsContainer").click();
        $("#subjectsContainer").setValue("c");



        //$("#dateOfBirthInput").setValue("01.01.23");
    }
}
