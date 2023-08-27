package com.demoqa.pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class ResultsTableComponent {

    SelenideElement tableResults = $(".table-responsive");

    public void checkResults(String value) {
        tableResults.shouldHave(text(value));
    }

}
