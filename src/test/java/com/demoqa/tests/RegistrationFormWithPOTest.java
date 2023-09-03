package com.demoqa.tests;

import com.codeborne.selenide.Configuration;
import com.demoqa.pages.RegistrationPage;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class RegistrationFormWithPOTest {

    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1600x720";
        Configuration.pageLoadStrategy = "eager";
    }

    RegistrationPage registrationPage = new RegistrationPage();
    @Test
    void fullFormTest() {

        registrationPage.openPage()
                .setFirstName("Test")
                .setLastName("Testov")
                .setUserEmail("Testov@mail.ru")
                .setGender("Male")
                .setUserNumber("9998887777")
                .setBitrhDate("20", "May", "1996")
                .setSubject("Maths")
                .setHobbies("Sports")
                .uploadPicture("images.jpg")
                .setCurrentAddress("10, Lomonosova st, Moscow")
                .setState("Haryana")
                .setCity("Panipat")
                .submitAction()

                .checkTableTitle("Thanks for submitting the form")
                .checkResultsTable(new String[]{
                        "Test Testov",
                        "Testov@mail.ru",
                        "Male",
                        "9998887777",
                        "20 May,1996",
                        "Maths",
                        "Sports",
                        "images.jpg",
                        "10, Lomonosova st, Moscow",
                        "Haryana Panipat"});
    }
        }

