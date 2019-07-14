package Automation_Best_Practices_and_Patterns;

import org.apache.log4j.PropertyConfigurator;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import static Automation_Best_Practices_and_Patterns.AbstractPage.LOGGER;

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
        String log4jConfPath = (System.getProperty("user.dir") + "/src/test/java/Automation_Best_Practices_and_Patterns/log4j.properties");
        PropertyConfigurator.configure(log4jConfPath);
        LOGGER.info("Start");
    }

    public void onFinish(ITestContext iTestContext) {
        LOGGER.info("Finish");
    }
}
