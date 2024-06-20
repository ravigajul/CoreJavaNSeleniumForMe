package com.example.selenium.interactions;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.example.selenium.misc.BaseTest;

public class MouseOperations extends BaseTest {

    @BeforeMethod
    public void navigateTo() {
        driver.get("https://the-internet.herokuapp.com/");
    }

    @Test
    public void clickElement() {
        WebElement contextMenuLink = driver.findElement(By.xpath("//a[text()='Context Menu']"));
        Actions actions = new Actions(driver);
        actions.click(contextMenuLink).build().perform();
        actions.click(driver.findElement(By.id("hot-spot")));
    }

    @Test
    public void rightClickOrContextMenu() {
        driver.findElement(By.xpath("//a[text()='Context Menu']")).click();
        WebElement contextMenu = driver.findElement(By.xpath("//div[@id='hot-spot']"));
        Actions actions = new Actions(driver);
        actions.contextClick(contextMenu).build().perform();

        // This alert is trigger by context click or right click
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }

    @Test
    public void dragNDrop() {
        driver.navigate().to("https://demo.automationtesting.in/Static.html");
        WebElement angular = driver.findElement(By.cssSelector("img#angular"));
        WebElement mongo = driver.findElement(By.cssSelector("img#mongo"));
        WebElement node = driver.findElement(By.cssSelector("img#node"));
        WebElement dropArea = driver.findElement(By.cssSelector("div#droparea"));
        Actions actions = new Actions(driver);
        actions.dragAndDrop(angular, dropArea).build().perform();
        actions.dragAndDrop(mongo, dropArea).build().perform();
        actions.dragAndDrop(node, dropArea).build().perform();
    }

    @Test
    public void clickAndHold() {
        driver.navigate().to("https://demo.automationtesting.in/Resizable.html");
        WebElement resizeHandle = driver.findElement(By.cssSelector("div.ui-resizable-handle.ui-icon"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView", resizeHandle);
        Actions actions = new Actions(driver);
        actions.clickAndHold(resizeHandle).moveByOffset(500, 5).release().perform();
    }

}
