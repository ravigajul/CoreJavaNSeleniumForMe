package com.example.selenium.exceptions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.example.selenium.misc.BaseTest;

public class seleniumexceptions extends BaseTest {

    @Test
    public void noSuchElementExceptionTest() {
        driver.get("https://formy-project.herokuapp.com/form");
        driver.findElement(By.cssSelector("#firstname")).sendKeys("John");
    }

    @Test
    public void staleElementReferenceExceptionTest() {
        driver.get("https://formy-project.herokuapp.com/form");
        WebElement firstName = driver.findElement(By.cssSelector("#first-name"));
        driver.navigate().refresh();
        firstName.sendKeys("John");
    }

    @Test
    public void webDriverExceptionTest() {
        driver.get("https://formy-project.herokuapp.com/form");
        driver.quit();
        driver.findElement(By.cssSelector("#first-name")).sendKeys("John");
    }

    @Test
    public void noAlertPresentExceptionTest() {
        driver.get("https://formy-project.herokuapp.com/form");
        driver.switchTo().alert().accept();
    }

    @Test
    public void invalidSelectorExceptionTest() {
        driver.get("https://formy-project.herokuapp.com/form");
        driver.findElement(By.cssSelector("first-name]")).sendKeys("John");
    }

    @Test
    public void JavascriptExceptionTest() {
        driver.get("https://formy-project.herokuapp.com/form");
        driver.executeScript("document.getElementById('first-name').value='John'");
    }
}
