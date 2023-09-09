package com.demoqa.tests.allure;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.linkText;

public class LyambdaTest {

    @Test
    public void tetIssueSearch() {

        SelenideLogger.addListener("allure", new AllureSelenide());

        step("Открываем главную страницу", () -> {
                    open("http://github.com");
                });
        step("Нажимаем на поле ввода", () -> {
        $(".header-search-button").click();
                });
        step("Вводим 'D1naraM/demoqa-tests' для поиска", () -> {
        $(".FormControl-medium").sendKeys("D1naraM/demoqa-tests");
                });
        step("Запускаем поиск", () -> {
        $(".FormControl-medium").submit();
                });
        step("Переходим по ссылке 'D1naraM/demoqa-tests'", () -> {
        $(linkText("D1naraM/demoqa-tests")).click();
                });
        step("Нажимаем на вкладку 'issues'", () -> {
        $("#issues-tab").click();
                });
        step("Проверяем наличие 'Test Issue'", () -> {
        $(withText("Test Issue")).should(Condition.exist);
                });
    }
}
