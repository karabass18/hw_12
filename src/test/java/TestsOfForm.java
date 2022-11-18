import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TestsOfForm {
    @BeforeAll
    static void beforeAll() {
        Configuration.holdBrowserOpen = true;
        Configuration.browserSize = "720x1080";
    }

    @Test
    void fillFormTest() {
        String userName = "Vania";
        String userLastName = "Ivanov";
        String userEmail = "vania@vania.com";
        String userGen = "Other";
        String userPhone = "0123456789";
        String userBDDay = "01";
        String userBDMonth = "May";
        String userBDYear = "1913";
        String userSubj = "Chemistry";
        String userHobb = "Sports";
        String picPath = "src/test/resources/";
        String picName = "squid-game-anime.jpg";
        String userAdd = "Home Street";
        String userState = "Haryana";
        String userCity = "Karnal";

        open("https://demoqa.com/automation-practice-form");
        $("#firstName").setValue(userName);
        $("#lastName").setValue(userLastName);
        $("#userEmail").setValue(userEmail);
        $("[name = 'gender']" + "[value = " + userGen + "]").doubleClick();
        $("#userNumber").setValue(userPhone);
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").click();
        $(".react-datepicker__month-select").selectOption(userBDMonth);
        $(".react-datepicker__year-select").click();
        $(".react-datepicker__year-select").selectOption(userBDYear);
        $(".react-datepicker__year-select").click();
        $(".react-datepicker__day--0" + userBDDay).click();
        $("#subjectsContainer").click();
        $("#uploadPicture").scrollIntoView(true);
        $("#subjectsContainer #subjectsInput").setValue(userSubj).pressEnter();
        $("#hobbiesWrapper").$(byText(userHobb)).click();
        $("#uploadPicture").uploadFile(new File(picPath + picName));
        $("#currentAddress").setValue(userAdd);
        $("#submit").scrollIntoView(true);
        $("#state ").click();
        $(byText(userState)).click();
        $("#city ").click();
        $(byText(userCity)).click();
        $("#submit").click();

        $(".modal-header").shouldHave(text("Thanks for submitting the form"));
        $(".modal-body").shouldHave(text(userName + " " + userLastName), text(userEmail), text(userGen),
                text(userPhone), text(userBDDay + " " + userBDMonth + "," + userBDYear), text(userSubj), text(userHobb), text(picName), text(userAdd),
                text(userState + " " + userCity));

    }
}