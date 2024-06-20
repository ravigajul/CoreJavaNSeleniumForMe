package com.example.selenium.widgets;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.example.selenium.misc.BaseTest;

public class Slider extends BaseTest {

    @Test
    public void dragAndDropSlider() {
        driver.get("https://the-internet.herokuapp.com/horizontal_slider");
        WebElement slider = driver.findElement(By.xpath("//input[@type='range']"));
        WebElement range = driver.findElement(By.id("range"));
        Actions actions = new Actions(driver);
        Assert.assertEquals(range.getText(), "0");
        // actions.click(slider).sendKeys(Keys.ARROW_RIGHT).perform();
        actions.dragAndDrop(slider, range).perform();
        Assert.assertEquals(range.getText(), "5");
    }

    @Test
    public void moveSliderByOffset() {
        driver.get("https://the-internet.herokuapp.com/horizontal_slider");
        WebElement slider = driver.findElement(By.xpath("//input[@type='range']"));
        WebElement range = driver.findElement(By.id("range"));
        Actions actions = new Actions(driver);
        Assert.assertEquals(range.getText(), "0");
        actions.clickAndHold(slider).moveByOffset(55, 0).release().perform();
        Assert.assertEquals(range.getText(), "5");

    }

    @Test
    public void moveSliderUsingKeyBoardArrowKey() {
        driver.get("https://the-internet.herokuapp.com/horizontal_slider");
        WebElement slider = driver.findElement(By.xpath("//input[@type='range']"));
        WebElement range = driver.findElement(By.id("range"));
        Actions actions = new Actions(driver);
        Assert.assertEquals(range.getText(), "0");
        actions.click(slider).sendKeys(Keys.ARROW_RIGHT).perform();
        Assert.assertEquals(range.getText(), "3");
    }

}
