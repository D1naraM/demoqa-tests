package com.demoqa.tests;

import com.codeborne.selenide.Configuration;
import com.demoqa.pages.TextBoxPage;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


public class TextBoxTest {
    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";
    }

    TextBoxPage textBoxPage = new TextBoxPage();

    @Test
    void fillFormTest() {
        textBoxPage.openPage()
                .setUserName("Test Testov")
                .setUserEmail("test@test.com")
                .setUserCurrentAddress("Pervaya st, Moscow city, Russia")
                .setUserPermanentAddress("Walk st, New York city, USA")
                .submitForm();

        textBoxPage.checkResult(new String[]{
                "Test Testov",
                "test@test.com",
                "Pervaya st, Moscow city, Russia",
                "Walk st, New York city, USA"});
    }
}

