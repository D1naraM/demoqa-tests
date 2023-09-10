package com.demoqa.tests;

import com.demoqa.helpers.Attach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;


public class RegistrationFormTest extends RemoteTestBase {

   // @BeforeAll
   // static void beforeAll() {
   //     Configuration.baseUrl = "https://demoqa.com";
    //    Configuration.browserSize = "1600x720";
   //     Configuration.pageLoadStrategy = "eager";
   //     Configuration.remote = "https://user1:1234@selenoid.autotests.cloud/wd/hub";
  //  }

    @Test
    @Tag("jenkins")
    @DisplayName("Successful registration")
    void successfulRegistrationTest() {

        step("Open form", () -> {
        open("/automation-practice-form");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        //Configuration.remote = "https://user1:1234@selenoid.autotests.cloud/wd/hub";
        });

        step("Fill form", () -> {
        $("#firstName").setValue("Test");
        $("#lastName").setValue("Testov");
        $("#userEmail").setValue("Testov@mail.ru");
        $("#genterWrapper").$(byText("Male")).click();
        $("#userNumber").setValue("9998887777");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("May");
        $(".react-datepicker__year-select").selectOption("1996");
        $(".react-datepicker__day--020").click();
        $("#subjectsInput").setValue("Maths").pressEnter();
        $("#hobbiesWrapper").$(byText("Sports")).click();
        $("#uploadPicture").uploadFromClasspath("images.jpg");
        $("#currentAddress").setValue("10, Lomonosova st, Moscow");
        $("#state").click();
        $("#stateCity-wrapper").$(byText("Haryana")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Panipat")).click();
        $("#submit").scrollTo();
        $("#submit").submit();
        });

        step("Verify results", () -> {
        $(".modal-content").shouldHave(text("Thanks for submitting the form"));
        $("#closeLargeModal").scrollTo();
        $(".table-responsive").shouldHave(
                text("Test"),
                text("Testov"),
                text("Testov@mail.ru"),
                text("Male"),
                text("9998887777"),
                text("20 May,1996"),
                text("Maths"),
                text("Sports"),
                text("images.jpg"),
                text("10, Lomonosova st, Moscow"),
                text("Haryana Panipat")
        );
        });;
    }
}
