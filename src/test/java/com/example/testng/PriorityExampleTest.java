package com.example.testng;

import org.testng.annotations.Test;

public class PriorityExampleTest {

    @Test(priority = 1)
    public void testMethod1() {
        System.out.println("Executing Test Method 1");
    }

    @Test(priority = 2)
    public void testMethod2() {
        System.out.println("Executing Test Method 2");
    }

    @Test(priority = 3)
    public void testMethod3() {
        System.out.println("Executing Test Method 3");
    }
}

