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

        ExtentReports extent = ExtentManager.getInstance();

        ExtentTest test = extent.createTest(
                result.getMethod().getMethodName(),
                result.getMethod().getDescription()
        );

        ExtentTestManager.setTest(test);
    }

    @Override
    public void onTestSuccess(ITestResult result) {

        ExtentTestManager.getTest().pass("Test passed successfully..!!");
        ExtentTestManager.unload();
    }

    @Override
    public void onTestFailure(ITestResult result) {

        try {
            String screenshotPath =
                    Screenshotutils.takeScreenshot(
                            result.getMethod().getMethodName()
                    );

            ExtentTest test = ExtentTestManager.getTest();
            if (test != null) {
                test.fail(result.getThrowable(),
                        MediaEntityBuilder
                                .createScreenCaptureFromPath(screenshotPath)
                                .build());
            }
        } catch (Exception e) {
            e.printStackTrace(); // NEVER throw
        } finally {
            ExtentTestManager.unload();
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        ExtentTestManager.unload();
    }

    @Override
    public void onStart(ITestContext context) {

    }

    @Override
    public void onFinish(ITestContext context) {

        try {
            ExtentManager.flushReports();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
