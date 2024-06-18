package com.example.testng.retrymechanism;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.example.selenium.BaseTest;

public class TestLevelRetry extends BaseTest {
    
    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void sendKeyThroughActions() {
        driver.navigate().to("https://the-internet.herokuapp.com/forgot_password");
        WebElement email = driver.findElement(By.cssSelector("#email"));
        Actions actions = new Actions(driver);
        actions.sendKeys(email, "This is through actions").perform();
        assert email.getText().equals("This is through actions");
    }
}
