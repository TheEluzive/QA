package Util;

import Pages.BasePage;
import Tests.BaseTest;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.IOException;

import static Tests.BaseTest.LOGGER;

public class CustomListener implements ITestListener {


    public void onTestStart(ITestResult iTestResult) {
        LOGGER.info("Tests started!");
    }

    public void onTestSuccess(ITestResult iTestResult) {
        LOGGER.info("Tests successful finish");
    }

    public void onTestFailure(ITestResult iTestResult) {
        LOGGER.info("Tests Failure");
        try {
            BaseTest.makeScreen("testFailure");
        } catch (IOException e) {
            e.printStackTrace();
        }
        BasePage.driver.quit();
    }

    public void onTestSkipped(ITestResult iTestResult) {
        LOGGER.info("Tests Skipped");
        BasePage.driver.quit();
    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
        try {
            BaseTest.makeScreen("testFailure");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void onStart(ITestContext iTestContext) {


    }

    public void onFinish(ITestContext iTestContext) {
        BasePage.driver.quit();
    }
}
