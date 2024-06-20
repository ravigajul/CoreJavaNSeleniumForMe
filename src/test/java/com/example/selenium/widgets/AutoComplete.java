package com.example.selenium.widgets;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.example.selenium.misc.BaseTest;

public class AutoComplete extends BaseTest {

    @Test
    public void testAutoComplete() {
        driver.get("https://gistcdn.githack.com/ravigajul/d60fb7fe4b1b4731c644c01f370e0d55/raw/04a207b1d5c97b2feeee18ebf701fa94e073ea82/AutoComplete.html");
        driver.findElement(By.cssSelector("#myInput")).sendKeys("G");
        driver.findElement(By.cssSelector("#myInputautocomplete-list div~div")).click();
    }

}
