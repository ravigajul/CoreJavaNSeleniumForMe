package com.example.testng.listeners;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.example.selenium.extentreports.ExtentReportManager;
import com.example.selenium.misc.BaseTest;
import com.example.utils.LoggerUtil;

public class ExtentReportListeners implements ITestListener {
    private static ExtentReports extent = ExtentReportManager.createInstance("target/Extent-Report.html");
    private static ThreadLocal<ExtentTest> test = new ThreadLocal<>();

    @Override
    public void onTestStart(ITestResult result) {
        LoggerUtil.info("Test Started - " + result.getMethod().getMethodName());
        System.out.println("Test Started: " + result.getMethod().getMethodName());
        ExtentTest extentTest = extent.createTest(result.getMethod().getMethodName());
        test.set(extentTest);
    }

    @Override
    public void onTestFailure(ITestResult result) {
        test.get().fail(result.getThrowable());

        WebDriver driver = ((BaseTest) result.getInstance()).getDriver();
        String screenshotBase64 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
        String screenshotPath = "data:image/png;base64," + screenshotBase64;
        test.get().fail("Screenshot on failure",
                MediaEntityBuilder.createScreenCaptureFromBase64String(screenshotPath).build());
                LoggerUtil.error("Test Failed - " + result.getMethod().getMethodName());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        test.get().skip(result.getThrowable());
        LoggerUtil.warn("Test Skipped - " + result.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        test.get().pass(result.getMethod().getMethodName());
        LoggerUtil.info("Test Successful - " + result.getMethod().getMethodName());
    }

    @Override
    public void onFinish(ITestContext context) {
        extent.flush();
        LoggerUtil.info("Test Finished - " + context.getCurrentXmlTest().getName());
    }

}
