package com.demoqa.pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class CalendarComponent {
   // SelenideElement
    //        setMonth = $(".react-datepicker__month-select"),
     //       setYear = $(".react-datepicker__year-select"),
     //       setDay = $(".react-datepicker__day--0" + day
     //               + ":not(.react-datepicker__day--outside-month)");


   // public void setDate(String day, String month, String year) {
   //     setMonth.selectOption(month);
   //     setYear.selectOption(year);
   //     setDay.click();

    public void setDate(String day, String month, String year) {
        $(".react-datepicker__month-select").selectOption(month);
        $(".react-datepicker__year-select").selectOption(year);
        $(".react-datepicker__day--0" + day +
                ":not(.react-datepicker__day--outside-month)").click();
    }
}
