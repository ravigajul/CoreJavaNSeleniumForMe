package com.example.selenium.listeners;

import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.example.selenium.BaseTest;
import com.example.selenium.extentreports.ExtentReportManager;

public class ExtentReportListeners implements ITestListener {
    private static ExtentReports extent = ExtentReportManager.createInstance("target/Extent-Report.html");
    private static ThreadLocal<ExtentTest> test = new ThreadLocal<>();

    @Override
    public void onTestStart(ITestResult result) {
        ExtentTest extentTest = extent.createTest(result.getMethod().getMethodName());
        test.set(extentTest);
    }

    @Override
    public void onTestFailure(ITestResult result) {
        test.get().fail(result.getThrowable());

        WebDriver driver = ((BaseTest)result.getInstance()).getDriver();
        String screenshotBase64 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BASE64);
        String screenshotPath = "data:image/png;base64," + screenshotBase64;
         test.get().fail("Screenshot on failure", MediaEntityBuilder.createScreenCaptureFromBase64String(screenshotPath).build());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        test.get().skip(result.getThrowable());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        test.get().pass(result.getMethod().getMethodName());
    }

    @Override
    public void onFinish(ITestContext context) {
        extent.flush();
    }

}
