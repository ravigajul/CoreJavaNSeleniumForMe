package com.example.selenium.pageobjectmodel.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {

    By txtUserName = By.id("user-name");
    By txtPassword = By.id("password");
    By btnSubmit = By.id("login-button");

    public HomePage(WebDriver driver) {
        super(driver);
        driver.get("https://www.saucedemo.com");
    }

    public ProductsPage login(String username, String password) {

        driver.findElement(txtUserName).sendKeys(username);
        driver.findElement(txtPassword).sendKeys(password);
        driver.findElement(btnSubmit).click();
        return new ProductsPage(driver);
    }

    public HomePage setUseName(String username) {
        driver.findElement(txtUserName).sendKeys(username);
        return this;
    }

    public HomePage setpassword(String password) {
        driver.findElement(txtPassword).sendKeys(password);
        return this;
    }

    public ProductsPage clickLogin() {
        driver.findElement(btnSubmit).click();
        return new ProductsPage(driver);
    }

}
