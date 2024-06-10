package com.example.selenium.interactions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.example.selenium.BaseTest;

public class DragAndDrop extends BaseTest {

     @BeforeMethod
     public void navigateTo() {
          driver.get("https://demo.automationtesting.in/Static.html");
     }

     @Test
     public void dragAndDrop() {

          WebElement angular = driver.findElement(By.cssSelector("img#angular"));
          WebElement mongo = driver.findElement(By.cssSelector("img#mongo"));
          WebElement node = driver.findElement(By.cssSelector("img#node"));
          WebElement dropArea = driver.findElement(By.cssSelector("div#droparea"));
          Actions actions = new Actions(driver);
          actions.dragAndDrop(angular, dropArea).build().perform();
          actions.dragAndDrop(mongo, dropArea).build().perform();
          actions.dragAndDrop(node, dropArea).build().perform();
     }

}
