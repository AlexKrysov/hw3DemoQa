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
        String Mobile = "1231231234";
        String Subjects = "biology";
        String CurrentAddress = "street 7";


        open("/automation-practice-form");


        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");

        $("#firstName").setValue(userName);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue(Email);
        $("#genterWrapper").$(new ByText("Male")).click();
        $("#userNumber").setValue(Mobile);
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("August");
        $(".react-datepicker__year-select").selectOption("1995");
        $(".react-datepicker__day--009:not(.react-datepicker__day--outside-month)").click();
        $("#subjectsInput").setValue(Subjects).pressEnter();
        $("#hobbiesWrapper").$(new ByText("Reading")).click();
        $("#uploadPicture").uploadFromClasspath("img/1.png");
        $("#currentAddress").setValue(CurrentAddress);
        $("#state").click();
        $("#stateCity-wrapper").$(new ByText("Uttar Pradesh")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(new ByText("Agra")).click();
        $("#submit").click();

        $(".modal-title").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").shouldHave(text("Ivan Ivanov"), text(Email), text("09 August,1995"), text("Male"), text(Subjects), text(CurrentAddress));





    }
}
