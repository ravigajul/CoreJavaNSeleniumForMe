package com.example.selenium;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest {
    protected WebDriver driver;
    protected String downloadsDirectory;
    protected String downloadFilePath;
    protected Wait<WebDriver> wait;

    @BeforeClass
    public void setUp() {

        // Create a map to store chrome options
        Map<String, String> prefs = new HashMap<>();

        downloadFilePath = Paths.get(System.getProperty("user.dir"), "downloads").toAbsolutePath().toString();

        // Configure Chrome preferences to specify the download directory and disable
        // the download prompt
        prefs.put("download.default_directory", downloadFilePath);
        prefs.put("download.prompt_for_download", "false");

        // Create ChromeOptions object
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs", prefs);

        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        // implicitwat
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

        // Ensure download directory exists
        Path downloadDir = Paths.get(downloadFilePath);
        try {
            if (!Files.exists(downloadDir)) {
                Files.createDirectories(downloadDir);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        // global wait
        wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20))
                .pollingEvery(Duration.ofSeconds(1)).ignoring(NoSuchElementException.class);
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
