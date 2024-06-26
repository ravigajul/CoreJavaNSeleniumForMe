package com.example.selenium.pageobjectmodel.tests;

import java.util.NoSuchElementException;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.example.selenium.misc.BaseTest;
import com.example.selenium.pageobjectmodel.pages.FinalPage;
import com.example.selenium.pageobjectmodel.pages.HomePage;
import com.example.selenium.pageobjectmodel.pages.ProductsPage;

public class SauceDemoTests extends BaseTest {
    private ProductsPage productsPage;
    private FinalPage finalPage;
    private HomePage homePage;

    @BeforeTest
    public void loginTest() {
        homePage = new HomePage(driver);
        productsPage = homePage.login("standard_user", "secret_sauce");
    }

    @Test
    public void addProductToCartTest() {
        productsPage.addProductToCart("Sauce Labs Backpack");
    }

    @Test
    public void removeProductFromCartTest() {
        try {
            productsPage.addProductToCart("Sauce Labs Backpack");
        } catch (NoSuchElementException e) {
            System.out.println("Product is already added or not availble");
        }
        productsPage.getCart().removeProductFromCart("Sauce Labs Backpack");
    }

    @Test
    public void checkOutTest() {
        try {
            productsPage.addProductToCart("Sauce Labs Backpack");
        } catch (NoSuchElementException e) {
            System.out.println("Product is already added or not availble");
        }
        finalPage = productsPage.getCart().checkOut().fillFormAndCheckOut("Ravi", "Gajul", "98272");
        String confirmationMsg = finalPage.getConfirmationMessage();
        Assert.assertEquals(confirmationMsg, "Thank you for your order!");
    }

    @Test
    public void allAllItems() {
        productsPage.addAllItemsToCart();
    }

    @Test
    public void fluentDemoTest(){

        // homePage.setUseName("standard_user");
        // homePage.setpassword("secret_sauce");
        // homePage.clickLogin();
        homePage.setUseName("standard_user").setpassword("secret_sauce").clickLogin();
        homePage.setUseName(downloadFilePath).setpassword("secret_sauce").clickLogin();
        System.out.println("Fluent Demo Test");
    }

}
