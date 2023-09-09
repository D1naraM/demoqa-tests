package com.demoqa.tests.allure;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;


import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;

public class SelenideTest {

    @Test
    public void issueSearchTest() {

        SelenideLogger.addListener("allure", new AllureSelenide());

        open("http://github.com");
        $(".header-search-button").click();
        $(".FormControl-medium").sendKeys("D1naraM/demoqa-tests");
        $(".FormControl-medium").submit();

        $(linkText("D1naraM/demoqa-tests")).click();
        $("#issues-tab").click();
        $(withText("Test Issue")).should(Condition.exist);




    }
}
