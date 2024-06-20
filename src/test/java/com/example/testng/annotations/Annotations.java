package com.example.testng.annotations;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.annotations.AfterMethod;
/**
 *  The scope of each TestNG annotation:
- **@BeforeSuite**: Runs once before all tests in the suite.
- **@AfterSuite**: Runs once after all tests in the suite.
- **@BeforeTest**: Runs once before any test methods in the `<test>` tag.
- **@AfterTest**: Runs once after all test methods in the `<test>` tag.
- **@BeforeClass**: Runs once before the first test method in the current class.
- **@AfterClass**: Runs once after all test methods in the current class.
- **@BeforeMethod**: Runs before each test method.
- **@AfterMethod**: Runs after each test method.
- **@Test**: Represents a test method.
 */
public class Annotations {

    @BeforeSuite
    public void beforeSuite() {
        System.out.println("Before Suite");
    }

    @BeforeTest
    public void beforeTest() {
        System.out.println("Before Test");
    }

    @BeforeClass
    public void beforeClass() {
        System.out.println("Before Class");
    }

    @BeforeMethod
    public void beforeMethod() {
        System.out.println("Before Method");
    }

    @Test
    public void test1() {
        System.out.println("Test 1");
    }

    @Test
    public void test2() {
        System.out.println("Test 2");
    }

    @AfterMethod
    public void AfterMethod() {
        System.out.println("After Method");
    }

    @AfterClass
    public void AfterClass() {
        System.out.println("After Class");
    }

    @AfterTest
    public void afterTest() {
        System.out.println("After Test");
    }

    @AfterSuite
    public void afterSuite() {
        System.out.println("After Suite");
    }

}
