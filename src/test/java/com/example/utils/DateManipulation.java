package com.example.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class DateManipulation {
    private String expectedDay;
    private String expectedShortMonth;
    private String expectedLongMonth;
    private String expectedYear;

    public String getExpectedDay() {
        return expectedDay;
    }

    public void setExpectedDay(String expectedDay) {
        this.expectedDay = expectedDay;
    }

    public String getExpectedShortMonth() {
        return expectedShortMonth;
    }

    public void setExpectedShortMonth(String expectedShortMonth) {
        this.expectedShortMonth = expectedShortMonth;
    }

    public String getExpectedLongMonth() {
        return expectedLongMonth;
    }

    public void setExpectedLongMonth(String expectedLongMonth) {
        this.expectedLongMonth = expectedLongMonth;
    }

    public String getExpectedYear() {
        return expectedYear;
    }

    public void setExpectedYear(String expectedYear) {
        this.expectedYear = expectedYear;
    }

    public void setFutureCalendarDay(int noOfDaysInFuture) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, noOfDaysInFuture); // Add 100 days

        // Format the date
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MMM/yyyy", Locale.US); // US format
        String expectedDate = sdf.format(calendar.getTime());

        // Extract month (short and long) and year
        String expectedDay = String.valueOf(calendar.get(Calendar.DAY_OF_MONTH));
        String expectedShortMonth = calendar.getDisplayName(Calendar.MONTH, Calendar.SHORT, Locale.US);
        String expectedLongMonth = calendar.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.US);
        String expectedYear = String.valueOf(calendar.get(Calendar.YEAR));

        System.out.println("Expected Day: " + expectedDay);
        System.out.println("Expected Date: " + expectedDate);
        System.out.println("Short Month: " + expectedShortMonth);
        System.out.println("Long Month: " + expectedLongMonth);
        System.out.println("Year: " + expectedYear);
        setExpectedDay(expectedDay);
        setExpectedLongMonth(expectedLongMonth);
        setExpectedShortMonth(expectedShortMonth);
        setExpectedYear(expectedYear);
    }

    public static String formatDate() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("MMMM yyyy");
        Date currentDate = new Date();
        String formattedDate = dateFormat.format(currentDate);
        System.out.println("Formatted date: " + formattedDate);
        return formattedDate;
    }
}
