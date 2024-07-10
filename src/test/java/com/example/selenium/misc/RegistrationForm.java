package com.example.selenium.misc;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.example.utils.LoggerUtil;

public class RegistrationForm extends BaseTest {

    @Test
    public void fillRegistrationForm() throws InterruptedException {

        driver.get("https://formy-project.herokuapp.com/form");
        LoggerUtil.info("Navigated to registration form");
        WebElement firstName = driver.findElement(By.cssSelector("#first-name"));
        WebElement lastName = driver.findElement(By.id("last-name"));
        WebElement jobTitle = driver.findElement(By.xpath("//input[@id='job-title']"));
        WebElement highSchool = driver.findElement(By.xpath("//input[@id='radio-button-1']"));
        WebElement prefCheckBox = driver.findElement(By.cssSelector("#checkbox-3"));

        firstName.sendKeys("Selenium");
        LoggerUtil.info("Enter first Name ");
        lastName.sendKeys("Training");
        LoggerUtil.info("Entered last name ");
        jobTitle.sendKeys("SDET");
        highSchool.click();
        LoggerUtil.info("Selected highschool");
        prefCheckBox.click();

        // selection
        WebElement dropDown = driver.findElement(By.cssSelector("#select-menu"));
        Select select = new Select(dropDown);
        select.selectByIndex(3);
        // select.selectByValue("2");
        // select.selectByVisibleText("Select an option");
        LoggerUtil.info("Selected drop down value");
        // implicit, explicit, fluentwait
        driver.findElement(By.cssSelector("#datepicker")).click();
        driver.findElement(By.xpath("//td[@class='today day']")).click();

        Thread.sleep(5000);

        // Submit
        driver.findElement(By.xpath("//a[text()='Submit']")).click();
        LoggerUtil.info("Submitted the registration page");
        // Getting text from success mes
        WebElement successMessageEle = driver.findElement(By.cssSelector("div.alert.alert-success"));
        String successMessage = successMessageEle.getText();
        LoggerUtil.info("Asserted success message");
        if (successMessage.equals("The form was successfully submitted!")) {
            System.out.println("Form Submitted sucessfully");
            LoggerUtil.info("Form submitted successfully");
        } else {
            System.out.println("Submission failed");
            LoggerUtil.error("Submission failed");
        }

    }
}
