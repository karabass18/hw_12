import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.selected;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class tests_of_form {
@Test
    void fillFormTest() {
        Configuration.holdBrowserOpen= true;
        Configuration.browserSize = "780x1080";

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
        String picPath = "src/test/files/";
        String picName = "squid-game-anime.jpg";
        String userAdd = "Home Street";
        String userState = "Haryana";
        String userCity = "Karnal";


        open("https://demoqa.com/automation-practice-form");
        $("#firstName").setValue(userName);
        $("#lastName").setValue(userLastName);
        $("#userEmail").setValue("vania@vania.com");
        $("#gender-radio-3").doubleClick();

        $("#userNumber").setValue("1234567890");
        $("#dateOfBirthInput").click();
        //$("[aria-label=\"Choose Thursday, December 10th, 2010\"]").click();
        $(".react-datepicker__month-select").click();
        $(".react-datepicker__month-select").selectOption("May");
        $(".react-datepicker__year-select").click();
        //$(".react-datepicker__year-select byText(\"1913\")").scrollTo();
        $(".react-datepicker__year-select").selectOption("1913");
        $(".react-datepicker__year-select").click();
        $(".react-datepicker__day--0" + "01").click();
        $("#subjectsContainer").click();
        $("#uploadPicture").scrollIntoView(true);
        $("#subjectsContainer #subjectsInput" ).setValue("Chemistry").pressEnter();

        $("[for=\"hobbies-checkbox-1\"]").click();

        //$("#uploadPicture").doubleClick();
        $("#uploadPicture").uploadFile(new File("src/test/files/squid-game-anime.jpg"));
        $("#currentAddress").setValue("Home Street");
        $("#submit").scrollIntoView(true);

        $("#state ").click();
        $(byText("Haryana")).click();
        $("#city ").click();
        $(byText("Karnal")).click();
        $("#submit").click();
        //$(".table-dark.")
        $("tr:nth-child(2) td:nth-child(2)").shouldHave(text("vania@vania.com"));
        //$("#dateOfBirthInput").setValue("01.01.23");
    }
}
