package Util;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;


import static Test.BaseTest.LOGGER;


public class CustomListener implements ITestListener {


    public void onTestStart(ITestResult iTestResult) {
        LOGGER.info("Test started!");
    }

    public void onTestSuccess(ITestResult iTestResult) {

        LOGGER.info("Test succesfull finish");
    }

    public void onTestFailure(ITestResult iTestResult) {
        LOGGER.info("Test Failure");
    }

    public void onTestSkipped(ITestResult iTestResult) {
        LOGGER.info("Test Skipped");
    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
        LOGGER.info("Test Failed But Within Success Percentage");
    }

    public void onStart(ITestContext iTestContext) {

        LOGGER.info("Suite Start");
    }

    public void onFinish(ITestContext iTestContext) {
        LOGGER.info("Suite Finish");
    }
}