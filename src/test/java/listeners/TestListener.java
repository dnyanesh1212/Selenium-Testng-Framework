package listeners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import reporter.ExtentManager;
import reporter.ExtentTestManager;
import utils.Screenshotutils;

import java.io.File;

public class TestListener implements ITestListener {

    @Override
    public void onTestStart(ITestResult result) {

        String className = result.getTestClass().getRealClass().getSimpleName();
        String methodName = result.getMethod().getMethodName();

        String testFolderName = className + "_" + methodName;

        String reportPath = System.getProperty("user.dir")
                            + "/reports/"
                            + testFolderName
                            + "/report.html";

        ExtentReports extent = ExtentManager.getInstance(reportPath);

        ExtentTest test = extent.createTest(methodName, result.getMethod().getDescription());

        ExtentTestManager.setTest(test);
    }

    @Override
    public void onTestSuccess(ITestResult result) {

        ExtentTestManager.getTest().pass("Test passed successfully..!!");
    }

    @Override
    public void onTestFailure(ITestResult result) {

        String className = result.getTestClass().getRealClass().getSimpleName();
        String methodName = result.getMethod().getMethodName();

        String testFolderName = className + "_" + methodName;
        String screenShotPath = null;
        try{
            screenShotPath = Screenshotutils.takeScreenshot(testFolderName);
        }
        catch (Exception e) {
            throw new RuntimeException("Failed to capture screenshot: " + e.getMessage());
        }

        String relativePath = "screenshots/" + new File(screenShotPath).getName();
        ExtentTestManager.getTest().fail(result.getThrowable(), MediaEntityBuilder.createScreenCaptureFromPath(relativePath).build());
    }

    @Override
    public void onTestSkipped(ITestResult result) {

    }

    @Override
    public void onStart(ITestContext context) {

    }

    @Override
    public void onFinish(ITestContext context) {
        ExtentManager.flushReports();
    }
}
