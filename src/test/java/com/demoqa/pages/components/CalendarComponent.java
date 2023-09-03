package com.demoqa.pages.components;

import com.codeborne.selenide.SelenideElement;
import com.demoqa.pages.TextBoxPage;

import static com.codeborne.selenide.Selenide.$;

public class CalendarComponent {
    SelenideElement
            setMonth = $(".react-datepicker__month-select"),
            setYear = $(".react-datepicker__year-select");


    public void setDate(String day, String month, String year) {
        setMonth.selectOption(month);
        setYear.selectOption(year);
        $(".react-datepicker__day--0" + day
                + ":not(.react-datepicker__day--outside-month)").click();

   // public void setDate(String day, String month, String year) {
     //   $(".react-datepicker__month-select").selectOption(month);
     //   $(".react-datepicker__year-select").selectOption(year);
      //  $(".react-datepicker__day--0" + day +
      //          ":not(.react-datepicker__day--outside-month)").click();
    }
}
