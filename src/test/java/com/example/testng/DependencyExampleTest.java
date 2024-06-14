package com.example.testng;

import org.testng.annotations.Test;

public class DependencyExampleTest {

    @Test
    public void loginTest() {
        System.out.println("Executing Login Test");
        // Perform login actions
    }

    @Test(dependsOnMethods = "loginTest")
    public void searchTest() {
        System.out.println("Executing Search Test");
        // Perform search actions
    }

    @Test(dependsOnMethods = "searchTest")
    public void logoutTest() {
        System.out.println("Executing Logout Test");
        // Perform logout actions
    }
}
