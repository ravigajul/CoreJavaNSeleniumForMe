package com.example.testng.assertions;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AssertionExamples {

    @Test
    public void testAssertEquals() {
        String expected = "Hello, World!";
        String actual = "Hello, World!";
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void testAssertTrue() {
        boolean condition = true;
        Assert.assertTrue(condition);
    }

    @Test
    public void testAssertFalse() {
        boolean condition = false;
        Assert.assertFalse(condition);
    }

    @Test
    public void testAssertNull() {
        Object obj = null;
        Assert.assertNull(obj);
    }

    @Test
    public void testAssertNotNull() {
        Object obj = new Object();
        Assert.assertNotNull(obj);
    }

    @Test
    public void testSoftAssert() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(false, "First assertion failed");
        softAssert.assertEquals(1, 2, "Second assertion failed");
        softAssert.assertAll(); // Report all collected errors
    }
}
