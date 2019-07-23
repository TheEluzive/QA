package Util;

import Test.BaseTest;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;


import java.io.IOException;

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
        try {
            BaseTest.makeScreen("editAddressesTest");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void onTestSkipped(ITestResult iTestResult) {
//        LOGGER.info("Test Skipped");
    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
        try {
            BaseTest.makeScreen("editAddressesTest");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void onStart(ITestContext iTestContext) {


    }

    public void onFinish(ITestContext iTestContext) {

    }
}
