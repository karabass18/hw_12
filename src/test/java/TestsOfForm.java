import Pages.FormPage;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TestsOfForm extends StartsSet {


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
        new FormPage().setFirstName(userName)
                .setLastName(userLastName)
                .setEmail(userEmail)
                .setGen(userGen)
                .setPhone((userPhone))
                .setBDay(userBDDay, userBDMonth, userBDYear);
        $("#subjectsContainer").click();
       // $("#uploadPicture").scrollIntoView(true);
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
        new FormPage().checkRegistrResultTabAppear()
                .checkRegistrResult("Student Name", userName + " " + userLastName);
        $(".modal-body").shouldHave(text(userName + " " + userLastName), text(userEmail), text(userGen), text(userPhone), text(userBDDay + " " + userBDMonth + "," + userBDYear), text(userSubj), text(userHobb), text(picName), text(userAdd), text(userState + " " + userCity));

    }
}