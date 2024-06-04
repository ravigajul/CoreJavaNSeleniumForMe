package com.example.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Main {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://formy-project.herokuapp.com/form");
        driver.findElement(By.xpath("//input[@id='first-name']")).sendKeys("Ravi");
        driver.findElement(By.xpath("//input[@id='last-name']")).sendKeys("Gajul");
        driver.findElement(By.cssSelector("#first-name")).sendKeys("Ravi");

        //id, class, attribute, partial text, fulltext, 
        //absolute, relative, axes, position, normalize-space, svg

        //tagname[@attribute="value"]
    };
}
