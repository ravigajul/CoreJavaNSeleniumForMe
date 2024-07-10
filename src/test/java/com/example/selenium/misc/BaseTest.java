package com.example.selenium.misc;

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
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.example.utils.DownloadFolderCleaner;
import com.example.utils.LoggerUtil;

public class BaseTest {
    protected static WebDriver driver;
    protected static String downloadsDirectory;
    protected static String downloadFilePath;
    protected static FluentWait<WebDriver> wait;

    @BeforeSuite
    public void setUp() {
        LoggerUtil.info("Setting up Chrome Options in base test");
        // Create a map to store chrome options
        Map<String, String> prefs = new HashMap<>();

        downloadFilePath = Paths.get(System.getProperty("user.dir"), "downloads").toAbsolutePath().toString();
        DownloadFolderCleaner.clearDownloadFolder(downloadFilePath);
        // Configure Chrome preferences to specify the download directory and disable
        // the download prompt
        prefs.put("download.default_directory", downloadFilePath);
        prefs.put("download.prompt_for_download", "false");

        // Create ChromeOptions object
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs", prefs);

        // ignoring certificate issues
        options.setAcceptInsecureCerts(true);

        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        // implicitwat
        LoggerUtil.info("Maximizing the browser window");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

        // Ensure download directory exists
        Path downloadDir = Paths.get(downloadFilePath);
        try {
            if (!Files.exists(downloadDir)) {
                Files.createDirectories(downloadDir);
                LoggerUtil.info("Created download directory");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Initialize the FluentWait
        wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20))
                .pollingEvery(Duration.ofSeconds(1)).ignoring(NoSuchElementException.class);

    }

    @AfterSuite
    public void tearDown() {
         driver.quit();
         LoggerUtil.info("Quit the browser");
    }

    public WebDriver getDriver() {
        return driver;
    }

}
