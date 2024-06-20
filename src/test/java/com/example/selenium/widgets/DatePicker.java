package com.example.selenium.widgets;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.example.selenium.misc.BaseTest;
import com.example.utils.DateManipulation;

public class DatePicker extends BaseTest {

    @Test
    public void selectFutureDateNoLoop() {
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
        // Alternatively without having to loop through all the dates
        driver.findElement(By.xpath(
                "//td[contains(@class, 'day') and not(contains(@class, 'old')) and not(contains(@class, 'new')) and normalize-space(text())='"
                        + expectedDay + "']"))
                .click();
    }

    @Test
    public void selectFutureDateLoop() {
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

        // css
        int size = driver.findElements(By.cssSelector("td.day:not(.old):not(.new)")).size();
        for (int i = 0; i < size; i++) {
            WebElement element = driver.findElements(By.cssSelector("td.day:not(.old):not(.new)")).get(i);
            String actualDay = element.getText();
            if (actualDay.equals(expectedDay)) {
                element.click();
                break;
            }
        }
    }
}
