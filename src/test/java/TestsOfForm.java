import Pages.FormPage;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

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
        FormPage formPage = new FormPage();


        step("Open the form", () ->{

        formPage.openForm();
        });

        step("Fill the form", () -> {
        formPage.setFirstName(userName)
                .setLastName(userLastName)
                .setEmail(userEmail)
                .setGen(userGen)
                .setPhone((userPhone))
                .setBDay(userBDDay, userBDMonth, userBDYear)
                .setSubj(userSubj)
                .setHobby(userHobb)
                .uploadPic(picPath + picName)
                .setAddress(userAdd)
                .setState(userState)
                .setCity(userCity)
                .submitInfo();
        });

        step("Check the result", () -> {
        formPage.checkRegistrResultTabAppear()
                .checkRegistrResult("Student Name", userName + " " + userLastName)
                .checkRegistrResult("Student Email", userEmail)
                .checkRegistrResult("Gender", userGen)
                .checkRegistrResult("Mobile", userPhone)
                .checkRegistrResult("Date of Birth", userBDDay + " " + userBDMonth + "," + userBDYear)
                .checkRegistrResult("Subjects", userSubj)
                .checkRegistrResult("Hobbies", userHobb)
                .checkRegistrResult("Picture", picName)
                .checkRegistrResult("Address", userAdd)
                .checkRegistrResult("State and City", userState + " " + userCity);
        });
    }
}