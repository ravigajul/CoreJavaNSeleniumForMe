package com.example.selenium.misc;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ShadowDom extends BaseTest {

    @BeforeMethod
    public void navigateTo() {
        driver.get(
                "https://gistcdn.githack.com/ravigajul/6ded388a94fe46c28e2281f6ec39a68b/raw/f6aba231534ae000cf6bb159b6b911f92f1606d9/ShadowDom.html");
    }

    @Test
    public void getTextFromShadowDom() {
        WebElement host = driver.findElement(By.cssSelector("custom-element"));
        SearchContext shadowRoot = host.getShadowRoot();
        String firstText = shadowRoot.findElement(By.cssSelector("div>p")).getText();
        Assert.assertEquals(firstText, "This is inside the Shadow DOM");
    }

    @Test
    public void getTextFromNestedShadowDom() {
        WebElement host = driver.findElement(By.cssSelector("custom-element"));
        SearchContext shadowRoot = host.getShadowRoot();
        WebElement nestedhost = shadowRoot.findElement(By.cssSelector("div nested-element"));
        SearchContext nestedRoot = nestedhost.getShadowRoot();
        String nestedText = nestedRoot.findElement(By.cssSelector("div p")).getText();
        Assert.assertEquals(nestedText, "This is inside the Nested Shadow DOM");
    }
}
