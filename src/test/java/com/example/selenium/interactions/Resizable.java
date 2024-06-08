package com.example.selenium.interactions;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.example.selenium.BaseTest;

public class Resizable extends BaseTest {

    @Test
    public void resizeTheTextArea() {
        driver.get("https://demo.automationtesting.in/Resizable.html");
        WebElement resizeHandle = driver.findElement(By.cssSelector("div.ui-resizable-handle.ui-icon"));
        WebElement resizeWidget = driver.findElement(By.cssSelector("div#resizable"));
        int xOffSet = resizeWidget.getSize().getWidth() - 5;
        int yOffSet = resizeWidget.getSize().getHeight() - 5;
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView", resizeHandle);
        Actions actions = new Actions(driver);
        actions.clickAndHold(resizeHandle).moveByOffset(500, 5).release().perform();

    }
}
