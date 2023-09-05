package com.demoqa.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class TextBoxPage {
    SelenideElement
            userName = $("#userName"),
            userEmail = $("#userEmail"),
            userCurrentAddress = $("#currentAddress"),
            userPermanentAddress = $("#permanentAddress"),
            submit = $("#submit"),
            nameOutput = $("#output #name"),
            emailOutput = $("#output #email"),
            currentAddressOutput = $("#output #currentAddress"),
            permanentAddressOutput = $("#output #permanentAddress");










    public TextBoxPage openPage() {
        open("/text-box");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        return this;
    }

    public TextBoxPage setUserName(String value) {
        userName.setValue(value);

        return this;
    }

    public TextBoxPage setUserEmail(String value) {
        userEmail.setValue(value);

        return this;
    }

    public TextBoxPage setUserCurrentAddress(String value) {
        userCurrentAddress.setValue(value);

        return this;
    }

    public TextBoxPage setUserPermanentAddress(String value) {
        userPermanentAddress.setValue(value);

        return this;
    }

    public TextBoxPage submitForm() {
        submit.click();

        return this;
    }

    public TextBoxPage checkResult(String[] values) {
        nameOutput.shouldHave(text(values[0]));
        emailOutput.shouldHave(text(values[1]));
        currentAddressOutput.shouldHave(text(values[2]));
        permanentAddressOutput.shouldHave(text(values[3]));

        return this;
    }

}
