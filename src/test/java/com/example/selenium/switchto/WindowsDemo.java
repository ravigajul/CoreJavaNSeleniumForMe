package com.example.selenium.switchto;

import java.util.Set;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.example.selenium.BaseTest;

public class WindowsDemo extends BaseTest {

    @BeforeMethod
    public void navigateTo() {
        driver.get("https://the-internet.herokuapp.com/windows");
    }

    @Test
    public void switchToNewWindow() throws InterruptedException {
        String originalWindowHandle = driver.getWindowHandle();
        driver.findElement(By.xpath("//a[normalize-space(text())='Click Here']")).click();
        Set<String> allWindowHandles = driver.getWindowHandles();
        for (String windowHandle : allWindowHandles) {
            if (!windowHandle.equalsIgnoreCase(originalWindowHandle)) {
                driver.switchTo().window(windowHandle);
                String textInNewWindow = driver.findElement(By.cssSelector("div.example h3")).getText();
                Assert.assertEquals(textInNewWindow, "New Window");
                driver.close();

            }
        }
        driver.switchTo().window(originalWindowHandle);

    }

    @Test
    public void switchWindows() throws InterruptedException {
        driver.findElement(By.xpath("//a[normalize-space(text())='Click Here']")).click();
        Set<String> allWindowHandles = driver.getWindowHandles();
        for (String windowHandle : allWindowHandles) {
            driver.switchTo().window(windowHandle);
            Thread.sleep(3000);
        }
    }

}
