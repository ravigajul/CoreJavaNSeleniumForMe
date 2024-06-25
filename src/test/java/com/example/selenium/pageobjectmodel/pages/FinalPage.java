package com.example.selenium.pageobjectmodel.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FinalPage extends BasePage{

    FinalPage(WebDriver driver) {
        super(driver);
    }

    public String getConfirmationMessage() {
        return driver.findElement(By.cssSelector("h2.complete-header")).getText();
    }
    
}
