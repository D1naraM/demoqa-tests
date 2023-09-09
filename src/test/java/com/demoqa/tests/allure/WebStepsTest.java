package com.demoqa.tests.allure;


import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;


public class WebStepsTest {

    @Test
    public void issueSearchTest() {

        SelenideLogger.addListener("allure", new AllureSelenide());
        WebSteps steps = new WebSteps();

        steps.openMainPage();
        steps.clickInputField();
        steps.enterValue();
        steps.clickToSearch();
        steps.followLink();
        steps.clickTheTab();
        steps.checkResult();
    }
}
