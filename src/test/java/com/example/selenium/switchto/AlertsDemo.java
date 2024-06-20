package com.example.selenium.switchto;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.example.selenium.misc.BaseTest;

public class AlertsDemo extends BaseTest {

    @BeforeMethod
    public void navigateTo() {
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
    }

    @Test
    public void jsAlert() {
        driver.findElement(By.xpath("//button[normalize-space(text())='Click for JS Alert']")).click();
        Alert alert = driver.switchTo().alert();
        alert.accept();

    }

    @Test
    public void jsConfirmOK() {
        driver.findElement(By.xpath("//button[normalize-space(text())='Click for JS Confirm']")).click();
        Alert alert = driver.switchTo().alert();
        // accepting alert, click ok

        alert.accept();
        String actualResult = driver.findElement(By.cssSelector("p#result")).getText();
        String expectedResult = "You clicked: Ok";
        Assert.assertEquals(expectedResult, actualResult);

    }

    @Test
    public void jsConfirmCancel() {
        driver.findElement(By.xpath("//button[normalize-space(text())='Click for JS Confirm']")).click();
        Alert alert = driver.switchTo().alert();

        // dismissing alert . click cancel
        alert.dismiss();
        String actualResult = driver.findElement(By.cssSelector("p#result")).getText();
        String expectedResult = "You clicked: Cancel";
        Assert.assertEquals(expectedResult, actualResult);

    }

    @Test
    public void jsPromptOK() {
        driver.findElement(By.xpath("//button[normalize-space(text())='Click for JS Prompt']")).click();
        Alert alert = driver.switchTo().alert();

        // dismissing alert . click cancel
        alert.sendKeys("Entering text into js prompt");
        alert.accept();
        String actualResult = driver.findElement(By.cssSelector("p#result")).getText();
        String expectedResult = "You entered: Entering text into js prompt";
        Assert.assertEquals(expectedResult, actualResult);

    }

    @Test
    public void jsPromptCancel() {
        driver.findElement(By.xpath("//button[normalize-space(text())='Click for JS Prompt']")).click();
        Alert alert = driver.switchTo().alert();

        // dismissing alert . click cancel
        alert.sendKeys("Entering text into js prompt");
        alert.dismiss();
        String actualResult = driver.findElement(By.cssSelector("p#result")).getText();
        String expectedResult = "You entered: null";
        Assert.assertEquals(expectedResult, actualResult);

    }

}
