package com.example.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class RegistrationForm extends BaseTest {

    @Test
    public void fillRegistrationForm() throws InterruptedException {

        driver.get("https://formy-project.herokuapp.com/form");
        WebElement firstName = driver.findElement(By.cssSelector("#first-name"));
        WebElement lastName = driver.findElement(By.id("last-name"));
        WebElement jobTitle = driver.findElement(By.xpath("//input[@id='job-title']"));
        WebElement highSchool = driver.findElement(By.xpath("//input[@id='radio-button-1']"));
        WebElement prefCheckBox = driver.findElement(By.cssSelector("#checkbox-3"));

        firstName.sendKeys("Selenium");
        lastName.sendKeys("Training");
        jobTitle.sendKeys("SDET");
        highSchool.click();
        prefCheckBox.click();

        // selection
        WebElement dropDown = driver.findElement(By.cssSelector("#select-menu"));
        Select select = new Select(dropDown);
        select.selectByIndex(3);
        // select.selectByValue("2");
        // select.selectByVisibleText("Select an option");

        // implicit, explicit, fluentwait
        driver.findElement(By.cssSelector("#datepicker")).click();
        driver.findElement(By.xpath("//td[@class='today day']")).click();

        Thread.sleep(5000);

        // Submit
        driver.findElement(By.xpath("//a[text()='Submit']")).click();

        // Getting text from success mes
        WebElement successMessageEle = driver.findElement(By.cssSelector("div.alert.alert-success"));
        String successMessage = successMessageEle.getText();

        if (successMessage.equals("The form was successfully submitted!")) {
            System.out.println("Form Submitted sucessfully");
        } else {
            System.out.println("Submission failed");
        }

    }
}
