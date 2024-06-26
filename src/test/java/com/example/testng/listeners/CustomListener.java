package com.example.testng.listeners;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(ListenersExample.class)
public class CustomListener {
    @Test(groups = { "group1" })
    public void testMethod1() {
        System.out.println("Test Method 1 - Group 1");
    }

    @Test(groups = { "group2" })
    public void testMethod2() {
        System.out.println("Test Method 2 - Group 2");
    }

    @Test(groups = { "group1", "group2" })
    public void testMethod3() {
        System.out.println("Test Method 3 - Group 1 and Group 2");
    }
}
