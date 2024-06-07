package com.example.selenium.widgets;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.example.utils.DateManipulation;

public class DatePicker {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.get("https://formy-project.herokuapp.com/form");
        driver.findElement(By.cssSelector("#datepicker")).click();
        DateManipulation dm = new DateManipulation();
        dm.setFutureCalendarDay(720);
        String expectedMonthYear = dm.getExpectedLongMonth() + " " + dm.getExpectedYear();
        String expectedDay = dm.getExpectedDay();

        String actualMonthYear = driver.findElement(By.cssSelector("div.datepicker-days th.datepicker-switch"))
                .getText();
        while (!expectedMonthYear.equals(actualMonthYear)) {
            driver.findElement(By.cssSelector("th.next")).click();
            actualMonthYear = driver.findElement(By.cssSelector("div.datepicker-days th.datepicker-switch")).getText();
        }

        /*
         * // css
         * List<WebElement> elements =
         * driver.findElements(By.cssSelector("td.day:not(.old):not(.new)"));
         * 
         * for (WebElement element : elements) {
         * System.out.println(element.getText());
         * if (element.getText().equals(expectedDay)) {
         * element.click();
         * }
         * }
         */

        // Alternatively without having to loop through all the dates
        driver.findElement(By.xpath(
                "//td[contains(@class, 'day') and not(contains(@class, 'old')) and not(contains(@class, 'new')) and normalize-space(text())='"
                        + expectedDay + "']"))
                .click();

    }
}
