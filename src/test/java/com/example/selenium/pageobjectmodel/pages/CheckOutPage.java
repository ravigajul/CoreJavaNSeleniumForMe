package com.example.selenium.pageobjectmodel.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class CheckOutPage extends BasePage {

    @FindBy(id = "first-name")
    private WebElement firstNameTxtBox;

    @FindBy(id = "last-name")
    private WebElement lastNameTxtBox;

    @FindBy(id = "postal-code")
    private WebElement zipCodeTxtBox;

    @FindBy(id = "continue")
    private WebElement continueBtn;

    @FindBy(css = "span.title")
    private WebElement title;

    @FindBy(id = "finish")
    private WebElement finishBtn;
    
    public CheckOutPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

   

    public FinalPage fillFormAndCheckOut(String firstName, String lastName, String zipCode) {
        firstNameTxtBox.sendKeys(firstName);
        lastNameTxtBox.sendKeys(lastName);
        zipCodeTxtBox.sendKeys(zipCode);
        continueBtn.click();
        Assert.assertEquals(title.getText(), "Checkout: Overview");
        finishBtn.click();
        return new FinalPage(driver);
    }
}
