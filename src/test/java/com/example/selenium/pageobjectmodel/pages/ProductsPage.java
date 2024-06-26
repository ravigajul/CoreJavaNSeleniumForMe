package com.example.selenium.pageobjectmodel.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductsPage extends BasePage {

    @FindBy(css = "a.shopping_cart_link")
    private WebElement cartLink;

    
    @FindBy(xpath = "//button[@id='checkout']")
    private WebElement checkOutBtn;

    @FindBy(xpath = "//button[text()='Add to cart']")
    private List<WebElement> addToCartBtns;

    ProductsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void addProductToCart(String productName) {

        driver.findElement(By.xpath("//div[text()='" + productName
                + "']/ancestor::div[@class='inventory_item_label']/following-sibling::div/button[text()='Add to cart']"))
                .click();
    }

    public void addAllItemsToCart() {
        for (WebElement addToBtn : addToCartBtns) {
            addToBtn.click();
        }
    }

    public void removeProductFromCart(String productName) {
        driver.findElement(By.xpath("//div[text()='" + productName + "']/ancestor::a/following-sibling::div/button"))
                .click();
    }

    public ProductsPage getCart() {
        cartLink.click();
        return this;
    }

    public CheckOutPage checkOut() {
        checkOutBtn.click();
        return new CheckOutPage(driver);
    }

}
