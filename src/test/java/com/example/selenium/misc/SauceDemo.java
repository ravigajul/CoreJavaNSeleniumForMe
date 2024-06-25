package com.example.selenium.misc;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SauceDemo extends BaseTest {

    @Test
    public void addAllItemsToCart() {
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        List<WebElement> allBtns = driver.findElements(By.xpath("//button[text()='Add to cart']"));
        for (WebElement btn : allBtns) {
            btn.click();
        }

        Assert.assertEquals(driver.findElement(By.cssSelector("span.shopping_cart_badge")).getText(), "6");
    }

}
