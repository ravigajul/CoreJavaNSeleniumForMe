package com.example.selenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class WaitsDemo extends BaseTest {

    @BeforeMethod
    public void navigateTo() {
        driver.get("http://uitestingplayground.com/ajax");
    }

    @Test
    public void explicitWaitTest() {
        // implicit wait. Implemented in base class
        // driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        driver.findElement(By.cssSelector(("#ajaxButton"))).click();

        // explicit wait
        WebElement successMessage = new WebDriverWait(driver, Duration.ofSeconds(18))
                .until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("p.bg-success")));

        assert successMessage.getText()
                .equals("Data loaded with AJAX get request.");

    }

    @Test
    public void fluentWaitTest() {

        driver.findElement(By.cssSelector(("#ajaxButton"))).click();

        // fluent wait
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20))
                .pollingEvery(Duration.ofSeconds(1)).ignoring(NoSuchElementException.class);
        WebElement successMessage = wait.until(driver -> driver.findElement(By.cssSelector("p.bg-success")));

        assert successMessage.getText()
                .equals("Data loaded with AJAX get request.");

    }

}
