package com.demoqa.tests;

import com.demoqa.pages.RegistrationPage;
import com.demoqa.utils.RandomUtils;
import org.junit.jupiter.api.Test;

public class RegistrationFormWithTestDataTest extends RegistrationFormTest {


    RegistrationPage registrationPage = new RegistrationPage();
    RandomUtils random = new RandomUtils();
    @Test
    void fullFormTest() {

        registrationPage.openPage()
                .setFirstName(random.userFirstName)
                .setLastName(random.userLastName)
                .setUserEmail(random.userEmail)
                .setGender(random.userGender)
                .setUserNumber(random.userNumber)
                .setBitrhDate(random.userBirthDay, random.userBirthMonth, random.userBirthYear)
                .setSubject(random.subject)
                .setHobbies(random.hobby)
                .uploadPicture(random.picture)
                .setCurrentAddress(random.userAddress)
                .setState(random.state)
                .setCity(random.city)
                .submitAction()

                .checkTableTitle("Thanks for submitting the form")
                .checkResultsTable(new String[]{
                        random.userFirstName + " " + random.userLastName,
                        random.userEmail,
                        random.userGender,
                        random.userNumber,
                        random.userBirthDay + " " + random.userBirthMonth + "," + random.userBirthYear,
                        random.subject,
                        random.hobby,
                        random.picture,
                        random.userAddress,
                        random.state + " " + random.city});
    }
}

