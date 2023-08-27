package com.demoqa.pages;

import com.codeborne.selenide.SelenideElement;
import com.demoqa.pages.components.CalendarComponent;
import com.demoqa.pages.components.ResultsTableComponent;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class RegistrationPage {

    CalendarComponent calendar = new CalendarComponent();
    ResultsTableComponent table = new ResultsTableComponent();


    SelenideElement
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            userEmailInput = $("#userEmail"),
            genderWrapper = $("#genterWrapper"),
            userNumber = $("#userNumber"),
            birthDateInput = $("#dateOfBirthInput"),
            subjectInput = $("#subjectsInput"),
            hobbiesWrapper = $("#hobbiesWrapper"),
            pictureUpload = $("#uploadPicture"),
            currentAddress = $("#currentAddress"),
            state = $("#state"),
            stateDropdown = $("#stateCity-wrapper"),
            sity = $("#city"),
            sityDropdown = $("#stateCity-wrapper"),
            submit = $("#submit"),
            tableTitle = $(".modal-content");


    public RegistrationPage openPage() {
        open("/automation-practice-form");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        return this;
    }

    public RegistrationPage setFirstName(String value) {
        firstNameInput.setValue(value);

        return this;
    }

    public RegistrationPage setLastName(String value) {
        lastNameInput.setValue(value);

        return this;
    }

    public RegistrationPage setUserEmail(String value) {
        userEmailInput.setValue(value);

        return this;
    }

    public RegistrationPage setGender(String value) {
        genderWrapper.$(byText(value)).click();

        return this;
    }

    public RegistrationPage setUserNumber(String value) {
        userNumber.setValue(value).click();

        return this;
    }

    public RegistrationPage setBitrhDate(String day, String month, String year) {
        birthDateInput.click();
        calendar.setDate(day, month, year);

        return this;
    }

    public RegistrationPage setSubject(String value) {
        subjectInput.setValue(value).pressEnter();

        return this;
    }

    public RegistrationPage setHobbies(String value) {
        hobbiesWrapper.$(byText(value)).click();

        return this;
    }

    public RegistrationPage uploadPicture(String value) {
        pictureUpload.uploadFromClasspath(value);

        return this;
    }

    public RegistrationPage setCurrentAddress(String value) {
        currentAddress.setValue(value);

        return this;
    }

    public RegistrationPage setState(String value) {
        state.click();
        stateDropdown.$(byText(value)).click();

        return this;
    }

    public RegistrationPage setSity(String value) {
        sity.click();
        sityDropdown.$(byText(value)).click();

        return this;
    }


    public RegistrationPage submitAction() {
        submit.scrollTo().submit();

        return this;
    }


    public RegistrationPage checkTableTitle(String value) {

        tableTitle.shouldHave(text(value));

        return this;
    }


    public RegistrationPage checkResultsTable(String[] values) {
        for (String value : values) {
            table.checkResults(value);
        }

        return this;
    }
}
