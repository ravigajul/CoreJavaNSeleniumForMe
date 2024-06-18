package com.example.testng.retrymechanism;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer {

    private int count = 0;
    private static final int retryLimit = 3; // Set your desired retry count
    //Check the sendkeys in keyboardoperations.java for example 
    @Override
    public boolean retry(ITestResult result) {
        if (!result.isSuccess() && count < retryLimit) {
            count++;
            return true;
        }
        return false;
    }
}

