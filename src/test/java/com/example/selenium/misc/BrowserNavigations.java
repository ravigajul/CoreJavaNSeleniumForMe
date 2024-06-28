package com.example.selenium.misc;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BrowserNavigations extends BaseTest {

    @BeforeMethod
    public void navigateTo() {

        driver.get("https://the-internet.herokuapp.com/");
    }

    @Test
    public void navigateToURL() {
        driver.navigate().to("https://the-internet.herokuapp.com/context_menu");
        assert driver.getCurrentUrl().equals("https://the-internet.herokuapp.com/context_menu");
    }

    @Test
    public void navigateBack() {
        driver.navigate().to("https://the-internet.herokuapp.com/context_menu");
        assert driver.getCurrentUrl().equals("https://the-internet.herokuapp.com/context_menu");
        driver.navigate().back();
        assert driver.getCurrentUrl().equals("https://the-internet.herokuapp.com/");
    }

    @Test
    public void navigateForward() {
        driver.navigate().to("https://the-internet.herokuapp.com/context_menu");
        assert driver.getCurrentUrl().equals("https://the-internet.herokuapp.com/context_menu");
        driver.navigate().back();
        assert driver.getCurrentUrl().equals("https://the-internet.herokuapp.com/");
        driver.navigate().forward();
        assert driver.getCurrentUrl().equals("https://the-internet.herokuapp.com/context_menu");
    }

    @Test
    public void refresh() {
        driver.navigate().refresh();
    }

}
