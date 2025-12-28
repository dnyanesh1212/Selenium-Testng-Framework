package listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import utils.Screenshotutils;

public class TestListener implements ITestListener {

    @Override
    public void onTestStart(ITestResult result) {

    }

    @Override
    public void onTestSuccess(ITestResult result) {

    }

    @Override
    public void onTestFailure(ITestResult result) {

        String className = result.getTestClass().getRealClass().getSimpleName();
        String methodName = result.getMethod().getMethodName();

        String testFolderName = className + "_" + methodName;

        try{
            String screenShotPath = Screenshotutils.takeScreenshot(testFolderName);
            System.out.println("Screenshot saved at : " + screenShotPath);
        } catch (Exception e) {
            throw new RuntimeException("Failed to capture screenshot: " + e.getMessage());
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {

    }

    @Override
    public void onStart(ITestContext context) {

    }

    @Override
    public void onFinish(ITestContext context) {

    }
}
