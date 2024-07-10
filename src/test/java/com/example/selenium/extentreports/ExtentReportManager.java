package com.example.selenium.extentreports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.example.utils.LoggerUtil;

public class ExtentReportManager {
    private static ExtentReports extent;

    public static ExtentReports createInstance(String fileName) {
        LoggerUtil.info("Creating ExtentSparkReporter");
        ExtentSparkReporter htmlReporter = new ExtentSparkReporter(fileName);
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
        return extent;
    }
}
