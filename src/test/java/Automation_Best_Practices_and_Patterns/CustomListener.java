package Automation_Best_Practices_and_Patterns;

import org.apache.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class CustomListener implements ITestListener {
    Logger logger = Logger.getLogger(Main.class);

    public void onTestStart(ITestResult iTestResult) {
        logger.info("Test started!");;
    }

    public void onTestSuccess(ITestResult iTestResult) {

        logger.info("Test succesfull finish");
    }

    public void onTestFailure(ITestResult iTestResult) {
        logger.info("Test Failure");
    }

    public void onTestSkipped(ITestResult iTestResult) {
        System.out.println("Test Skipped");
    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
        System.out.println("Test Failed But Within Success Percentage");
    }

    public void onStart(ITestContext iTestContext) {
        System.out.println("Start");
    }

    public void onFinish(ITestContext iTestContext) {
        System.out.println("Finish");
    }
}
