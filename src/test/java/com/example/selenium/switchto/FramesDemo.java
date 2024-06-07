package com.example.selenium.switchto;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ById;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.example.selenium.BaseTest;

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
    public void nestedIFrames() {
        driver.navigate().to("https://the-internet.herokuapp.com/nested_frames");
        String expectedText = "MIDDLE";
        String actualText = driver.switchTo().frame("frame-top").switchTo().frame("frameset-middle")
                .findElement(By.id("content")).getText();
        Assert.assertEquals(actualText, expectedText);
    }
}
