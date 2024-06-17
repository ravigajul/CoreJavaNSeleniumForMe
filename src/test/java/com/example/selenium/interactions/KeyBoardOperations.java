package com.example.selenium.interactions;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.example.selenium.BaseTest;
import com.example.selenium.retrymechanism.RetryAnalyzer;

public class KeyBoardOperations extends BaseTest {

    @BeforeMethod
    public void navigateTo() {
        driver.get("https://the-internet.herokuapp.com/");
    }

    public void sendKeyThroughActions() {
        driver.navigate().to("https://the-internet.herokuapp.com/forgot_password");
        WebElement email = driver.findElement(By.cssSelector("#email"));
        Actions actions = new Actions(driver);
        actions.sendKeys(email, "This is through actions").perform();
        assert email.getText().equals("This is through actions");
    }

    @Test
    public void pressTab() throws InterruptedException {
        driver.navigate().to("https://the-internet.herokuapp.com/key_presses");
        WebElement targetElement = driver.findElement(By.cssSelector("input#target"));
        targetElement.click();
        Actions actions = new Actions(driver);
        actions.sendKeys(targetElement, Keys.TAB).perform();
        assert driver.findElement(By.cssSelector("p#result")).getText().equals("You entered: TAB");
    }

    @Test
    public void pressESCAPE() throws InterruptedException {
        driver.navigate().to("https://the-internet.herokuapp.com/key_presses");
        WebElement targetElement = driver.findElement(By.cssSelector("input#target"));
        // targetElement.click();
        Actions actions = new Actions(driver);
        actions.sendKeys(targetElement, "a").perform();
        actions.sendKeys(targetElement, Keys.ESCAPE).perform();

        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20))
                .pollingEvery(Duration.ofSeconds(1)).ignoring(NoSuchElementException.class);
        WebElement textMessage = wait.until(driver -> driver.findElement(By.cssSelector("p#result")));

        assert textMessage.getText().equals("You entered: ESCAPE");
    }

    @Test
    public void controlA() {

        driver.navigate().to("https://the-internet.herokuapp.com/key_presses");
        WebElement targetElement = driver.findElement(By.cssSelector("input#target"));
        targetElement.sendKeys("some text");
        targetElement.sendKeys(Keys.CONTROL, "a");
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20))
                .pollingEvery(Duration.ofSeconds(1)).ignoring(NoSuchElementException.class);
        WebElement textMessage = wait.until(driver -> driver.findElement(By.cssSelector("p#result")));
        assert textMessage.getText().equals("You entered: A");

    }

    @Test
    public void clearAllText() {
        driver.navigate().to("https://the-internet.herokuapp.com/key_presses");
        WebElement targetElement = driver.findElement(By.cssSelector("input#target"));
        targetElement.sendKeys("some text");
        targetElement.sendKeys(Keys.CONTROL, "a");
        targetElement.sendKeys(Keys.DELETE);
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20))
                .pollingEvery(Duration.ofSeconds(1)).ignoring(NoSuchElementException.class);
        WebElement textMessage = wait.until(driver -> driver.findElement(By.cssSelector("p#result")));
        assert textMessage.getText().equals("You entered: DELETE");
    }

    @Test
    public void pressFunctionKeyF5() {
        driver.navigate().to("https://the-internet.herokuapp.com/key_presses");
        WebElement targetElement = driver.findElement(By.cssSelector("input#target"));
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.F5).perform();
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20))
                .pollingEvery(Duration.ofSeconds(1)).ignoring(NoSuchElementException.class);
        WebElement textMessage = wait.until(driver -> driver.findElement(By.cssSelector("p#result")));
        assert textMessage.getText().equals("You entered: F5");
    }
}
