package com.example.selenium.switchto;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.example.selenium.misc.BaseTest;

public class FramesDemo extends BaseTest {

    @BeforeMethod
    public void navigateTo() {
        driver.get("https://the-internet.herokuapp.com/frames");
    }

    @Test
    public void iFrameDemo() {
        driver.findElement(By.xpath("//a[text()='iFrame']")).click();
        driver.switchTo().frame("mce_0_ifr");
        String text = driver.findElement(By.cssSelector("body#tinymce p")).getText();
        Assert.assertEquals(text, "Your content goes here.");
    }

    @Test
    public void switchToLeftFrame() {
        driver.navigate().to("https://the-internet.herokuapp.com/nested_frames");
        String expectedText = "LEFT";
        String actualText = driver.switchTo().frame("frame-top").switchTo().frame("frame-left")
                .findElement(By.xpath("//body")).getText();
        Assert.assertEquals(actualText, expectedText);
    }

    @Test
    public void switchToMiddleFrame() {
        driver.navigate().to("https://the-internet.herokuapp.com/nested_frames");
        String expectedText = "MIDDLE";
        String actualText = driver.switchTo().frame("frame-top").switchTo().frame("frame-middle")
                .findElement(By.xpath("//body")).getText();
        Assert.assertEquals(actualText, expectedText);
    }

    @Test
    public void switchToRightFrame() {
        driver.navigate().to("https://the-internet.herokuapp.com/nested_frames");
        String expectedText = "RIGHT";
        String actualText = driver.switchTo().frame("frame-top").switchTo().frame("frame-right")
                .findElement(By.xpath("//body")).getText();
        Assert.assertEquals(actualText, expectedText);
    }

    @Test
    public void switchToBottomFrame() {
        driver.navigate().to("https://the-internet.herokuapp.com/nested_frames");
        String expectedText = "BOTTOM";
        String actualText = driver.switchTo().frame("frame-bottom")
                .findElement(By.xpath("//body")).getText();
        Assert.assertEquals(actualText, expectedText);
    }

    @Test
    public void switchToDefaultContent() {
        driver.get("https://the-internet.herokuapp.com/nested_frames");

        WebDriver topFrame = driver.switchTo().frame("frame-top");
        WebDriver leftFrame = topFrame.switchTo().frame("frame-left");
        String textContent = leftFrame.findElement(By.cssSelector("body")).getText();
        assert textContent.equals("LEFT");
        driver.switchTo().defaultContent();
        assert driver.switchTo().frame("frame-bottom").findElement(By.cssSelector("body")).getText().equals("BOTTOM");
    }
}
