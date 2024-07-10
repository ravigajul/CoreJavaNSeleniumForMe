package com.example.selenium.misc;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.example.utils.LoggerUtil;

public class BrowserNavigations extends BaseTest {

    @BeforeMethod
    public void navigateTo() {
        LoggerUtil.info("Navigating to internet heroku app");
        driver.get("https://the-internet.herokuapp.com/");
    }

    @Test
    public void navigateToURL() {
        LoggerUtil.info("Navigating to internet herokuapp");
        driver.navigate().to("https://the-internet.herokuapp.com/context_menu");
        assert driver.getCurrentUrl().equals("https://the-internet.herokuapp.com/context_menu");
        LoggerUtil.info("Asserted Current url");
    }

    @Test
    public void navigateBack() {
        driver.navigate().to("https://the-internet.herokuapp.com/context_menu");
        assert driver.getCurrentUrl().equals("https://the-internet.herokuapp.com/context_menu");
        driver.navigate().back();
        assert driver.getCurrentUrl().equals("https://the-internet.herokuapp.com/");
        LoggerUtil.info("Navigated backward");
    }

    @Test
    public void navigateForward() {
        driver.navigate().to("https://the-internet.herokuapp.com/context_menu");
        assert driver.getCurrentUrl().equals("https://the-internet.herokuapp.com/context_menu");
        driver.navigate().back();
        assert driver.getCurrentUrl().equals("https://the-internet.herokuapp.com/");
        driver.navigate().forward();
        assert driver.getCurrentUrl().equals("https://the-internet.herokuapp.com/context_menu");
        LoggerUtil.info("Navigated forward");
    }

    @Test
    public void refresh() {
        driver.navigate().refresh();
        LoggerUtil.info("Browser Refreshed");
    }

}
