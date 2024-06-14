package com.example.testng;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class GoogleCalculatorTest {

    private WebDriver driver;

    @BeforeSuite
    public void setUp() {
        driver = new ChromeDriver();
    }

    @BeforeTest
    public void openGoogleCalculator() {
        // Open Google Calculator
        driver.get("https://www.google.com");
    }

    @BeforeClass
    public void maximizeWindow() {
        // Maximize browser window
        driver.manage().window().maximize();
    }

    @BeforeMethod
    public void clearInputField() {
        // Clear the input field before each test method
        WebElement inputField = driver.findElement(By.name("q"));
        inputField.clear();
    }

    @Test
    public void testAddition() {
        // Perform addition operation
        WebElement inputField = driver.findElement(By.name("q"));
        inputField.sendKeys("5 + 3");
        inputField.submit();
        // Add assertions here
    }

    @Test
    public void testSubtraction() {
        // Perform subtraction operation
        WebElement inputField = driver.findElement(By.name("q"));
        inputField.sendKeys("10 - 4");
        inputField.submit();
        // Add assertions here
    }

    @AfterMethod
    public void captureScreenshot() {
        // Capture a screenshot after each test method
        // Save the screenshot or perform other actions
    }

    @AfterClass
    public void closeBrowser() {
        // Close the browser after all methods in the class finish
        driver.quit();
    }

    @AfterTest
    public void cleanUp() {
        // Clean up any resources (if needed)
    }

    @AfterSuite
    public void generateReport() {
        // Generate test report after all suites finish
    }
}
