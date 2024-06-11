package com.example.selenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class WebTableScrapping extends BaseTest {

    @Test
    public void printTableData() {
        driver.get("https://the-internet.herokuapp.com/tables");
        WebElement tableBody = driver.findElement(By.cssSelector("table#table1 tbody"));
        // dot is important here otherwise it loops through all trs if multiple tables
        // are found
        List<WebElement> rows = tableBody.findElements(By.xpath(".//tr"));
        for (WebElement row : rows) {
            System.out.println("----------------------------------------------------");
            List<WebElement> cols = row.findElements(By.xpath(".//td"));
            for (WebElement col : cols) {
                System.out.print(col.getText());
                System.out.print("|");
            }
            System.out.println();
        }
    }
}
