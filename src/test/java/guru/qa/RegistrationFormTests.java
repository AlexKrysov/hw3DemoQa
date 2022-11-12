package guru.qa;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.selector.ByText;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationFormTests {
    @BeforeAll
    static void beforeAll() {
        Configuration.holdBrowserOpen = true;
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
    }

    @Test
    void fillFormTest() {

        String userName = "Ivan";
        String lastName = "Ivanov";
        String Email = "Ivan@ivanov.com";
        String Mobile = "1231231231";
        String Subjects = "Math";
        String CurrentAddress = "street 7";


        open("/automation-practice-form");
        $("#firstName").setValue(userName);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue(Email);
        $("#genterWrapper").$(new ByText("Male")).click();
        $("#userNumber").setValue(Mobile);
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("July");
        $(".react-datepicker__year-select").selectOption("2005");
        $(".react-datepicker__day--028:not(.react-datepicker__day--outside-month)").click();
        $("#subjectsInput").setValue(Subjects).pressEnter();
        $("#hobbiesWrapper").$(new ByText("Reading")).click();
        $("#uploadPicture").uploadFromClasspath("img/1.png");
        $("#currentAddress").setValue(CurrentAddress);
        $("#state").click();
        $("#stateCity-wrapper").$(new ByText("NCR")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(new ByText("Delhi")).click();
        $("#submit").click();

        $(".modal-title").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").shouldHave(text("Ivan Ivanov"), text(Email), text("28 July,2005"), text("Male"), text(Subjects), text(CurrentAddress));





    }
}
