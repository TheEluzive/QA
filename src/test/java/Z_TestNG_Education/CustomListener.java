package Z_TestNG_Education;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

class CustomListener implements ITestListener {
    public void onTestStart(ITestResult iTestResult) {
        System.out.println("Tests started!");
    }

    public void onTestSuccess(ITestResult iTestResult) {
        System.out.println("Tests Success");
    }

    public void onTestFailure(ITestResult iTestResult) {
        System.out.println("Tests Failure");
    }

    public void onTestSkipped(ITestResult iTestResult) {
        System.out.println("Tests Skipped");
    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
        System.out.println("Tests Failed But Within Success Percentage");
    }

    public void onStart(ITestContext iTestContext) {
        System.out.println("Start");
    }

    public void onFinish(ITestContext iTestContext) {
        System.out.println("Finish");
    }
}
