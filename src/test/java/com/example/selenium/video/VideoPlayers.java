package com.example.selenium.video;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.example.selenium.BaseTest;

public class VideoPlayers extends BaseTest {

    @BeforeMethod
    public void navigateTo() {
        driver.get("https://demo.automationtesting.in/Youtube.html");
    }

   
    @Test
    public void testVideoTitle() {

        WebElement iframe = driver.findElement(By.cssSelector("iframe[src*='youtube.com']"));
        driver.switchTo().frame(iframe);

        // Get video title
        WebElement videoTitle = driver.findElement(By.cssSelector("a[data-sessionlink='feature=player-title']"));
        assert videoTitle.getText().contains("Sakinalium Presentation");

    }

    @Test
    public void testVimeo() throws InterruptedException {
        driver.get("https://demo.automationtesting.in/Vimeo.html");

        // Switch to the iframe containing the YouTube video
        WebElement iframe = driver.findElement(By.cssSelector("iframe#foo"));
        driver.switchTo().frame(iframe);

        // Play the video
        WebElement playButton = driver.findElement(By.cssSelector("button[aria-labelledby='play-button-tooltip']"));
        playButton.click();
        Thread.sleep(5000); // Wait for 5 seconds to let the video play

        // Pause the video
        WebElement pauseButton = driver.findElement(By.cssSelector("button[aria-labelledby='play-button-tooltip']"));
        pauseButton.click();
        Thread.sleep(2000); // Wait for 2 seconds to verify the video is paused
    }
}
