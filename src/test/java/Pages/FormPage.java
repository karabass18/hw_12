package Pages;

import Pages.components.CalendarComp;
import Pages.components.ResultTab;

import static com.codeborne.selenide.Selenide.$;

public class FormPage {
    public FormPage setFirstName(String name) {
        $("#firstName").setValue(name);
        return this;
    }

    public FormPage setLastName(String lastName) {
        $("#lastName").setValue(lastName);
        return this;
    }

    public FormPage setEmail(String email) {
        $("#userEmail").scrollIntoView(true);
        $("#userEmail").setValue(email);
        return this;
    }

    public FormPage setGen(String gen) {
        $("[name = 'gender']" + "[value = " + gen + "]").doubleClick();
        return this;
    }

    public FormPage setPhone(String phone) {
        $("#userNumber").setValue(phone);
        return this;
    }
    public FormPage setBDay(String day, String month, String year) {
        $("#dateOfBirthInput").click();
        new CalendarComp().setDate(day, month, year);
        return this;
    }
    public FormPage checkRegistrResultTabAppear() {
        new ResultTab().checkResultTabAppear();
        return this;
    }
    public FormPage checkRegistrResult(String key, String value) {
        new ResultTab().checkResultTab(key, value);
        return this;
    }

}
