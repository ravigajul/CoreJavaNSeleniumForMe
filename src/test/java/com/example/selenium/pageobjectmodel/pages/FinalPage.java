package com.example.selenium.pageobjectmodel.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FinalPage extends BasePage {

    @FindBy(css = "h2.complete-header")
    private WebElement confirmationMessage;

    FinalPage(WebDriver driver) {
        super(driver);
    }

    public String getConfirmationMessage() {
        return confirmationMessage.getText();
    }

}
