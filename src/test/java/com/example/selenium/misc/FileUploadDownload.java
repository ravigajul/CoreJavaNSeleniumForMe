package com.example.selenium.misc;

import java.nio.file.Paths;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.model.Log;
import com.example.utils.LoggerUtil;

public class FileUploadDownload extends BaseTest {

    @Test
    public void fileUploadTest() throws InterruptedException {
        LoggerUtil.info("Running fileUpload Test");
        driver.get("https://the-internet.herokuapp.com/upload");
        driver.findElement(By.cssSelector("input#file-upload")).sendKeys("C:\\Users\\anjal\\Downloads\\test.txt");
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("input#file-submit")).click();
        Assert.assertEquals(driver.findElement(By.cssSelector("div#uploaded-files")).getText(), "test.txt");
        
    }

    @Test
    public void fileDownload() throws InterruptedException {
        LoggerUtil.info("Running fileUpload Test");
        driver.get("https://the-internet.herokuapp.com/download");
        driver.findElement(By.xpath("//a[text()='test.txt']")).click();
        Thread.sleep(2000);

        java.nio.file.Path downloadedFilePath = Paths.get(downloadFilePath, "test.txt");
        if (java.nio.file.Files.exists(downloadedFilePath)) {
            System.out.println("File downloaded successfully: " + downloadedFilePath);
            LoggerUtil.info("File downloaded successfully: \" + downloadedFilePath");
        } else {
            System.out.println("File not downloaded.");
            LoggerUtil.error("File not Downloaded");
        }
    }

}
