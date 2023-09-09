package com.demoqa.tests.allure;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;

public class WebSteps {
    @Step("Открываем главную страницу")
    public void openMainPage() {
        open("https://github.com");
    }

    @Step("Нажимаем на поле ввода")
    public void clickInputField() {
        $(".header-search-button").click();
    }

    @Step("Вводим 'D1naraM/demoqa-tests' для поиска")
    public void enterValue() {
        $(".FormControl-medium").sendKeys("D1naraM/demoqa-tests");
    }

    @Step("Запускаем поиск")
    public void clickToSearch() {
        $(".FormControl-medium").submit();
    }

    @Step("Переходим по ссылке 'D1naraM/demoqa-tests'")
    public void followLink() {
        $(linkText("D1naraM/demoqa-tests")).click();
    }

    @Step("Нажимаем на вкладку 'issues'")
    public void clickTheTab() {
        $("#issues-tab").click();
    }

    @Step("Проверяем наличие 'Test Issue'")
    public void checkResult() {
        $(withText("Test Issue")).should(Condition.exist);
        attachScreenshot();
    }

    @Attachment(value = "Скриншот", type = "image/png", fileExtension = "png")
    public byte[] attachScreenshot() {
        return ((TakesScreenshot) WebDriverRunner.getWebDriver()).getScreenshotAs(OutputType.BYTES);
    }
}