package com.example.selenium.widgets;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.example.selenium.misc.BaseTest;

public class Accordion extends BaseTest {

    @Test
    public void accordion() {
        driver.get("https://demo.automationtesting.in/Accordion.html");
        // Locate the accordion sections
        WebElement section1 = driver.findElement(By.xpath("//b[contains(text(),'Readability')]"));
        WebElement section2 = driver.findElement(By.xpath("//b[contains(text(),'Coding')]"));
        WebElement section3 = driver.findElement(By.xpath("//b[contains(text(),'Chaining')]"));

        // Click to expand Section 1
        section1.click(); // by default it is expanded
        WebElement panel1 = driver.findElement(By.cssSelector("#collapse1 div.panel-body"));
        Assert.assertTrue(panel1.isDisplayed());

        // Click to expand Section 2
        section2.click();
        WebElement panel2 = driver.findElement(By.cssSelector("#collapse2 div.panel-body"));
        Assert.assertTrue(panel2.isDisplayed());

        // Click to expand Section 3
        section3.click();
        WebElement panel3 = driver.findElement(By.cssSelector("#collapse3 div.panel-body"));
        Assert.assertTrue(panel3.isDisplayed());

        // Click to collapse Section 3
        section3.click();

        WebElement panel4 = driver.findElement(By.cssSelector("#collapse3 div.panel-body"));
        Assert.assertTrue(panel4.isDisplayed());

    }

}
