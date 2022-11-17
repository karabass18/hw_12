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
        $("#userEmail").setValue(userEmail);
       // $("#gender-radio-3").doubleClick();

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
        $("#subjectsContainer #subjectsInput" ).setValue(userSubj).pressEnter();
        //$("[for=\"hobbies-checkbox-1\"]").click();

        //$(".custom-control-label ").
                $(byText(userHobb)).click();

        //$("#uploadPicture").doubleClick();
        $("#uploadPicture").uploadFile(new File(picPath + picName));
        $("#currentAddress").setValue(userAdd);
        $("#submit").scrollIntoView(true);

        $("#state ").click();
        $(byText(userState)).click();
        $("#city ").click();
        $(byText(userCity)).click();
        $("#submit").click();
        //$(".table-dark.")
        $("tr:nth-child(1) td:nth-child(2)").shouldHave(text(userName + " " + userLastName));
        $("tr:nth-child(2) td:nth-child(2)").shouldHave(text(userEmail));
        $("tr:nth-child(3) td:nth-child(2)").shouldHave(text(userGen));
        $("tr:nth-child(4) td:nth-child(2)").shouldHave(text(userPhone));
        $("tr:nth-child(5) td:nth-child(2)").shouldHave(text(userBDDay + " " + userBDMonth + "," + userBDYear));
        $("tr:nth-child(6) td:nth-child(2)").shouldHave(text(userSubj));
        $("tr:nth-child(7) td:nth-child(2)").shouldHave(text(userHobb));
        $("tr:nth-child(8) td:nth-child(2)").shouldHave(text(picName));
        $("tr:nth-child(9) td:nth-child(2)").shouldHave(text(userAdd));
        $("tr:nth-child(10) td:nth-child(2)").shouldHave(text(userState + " " + userCity));
    }
}
