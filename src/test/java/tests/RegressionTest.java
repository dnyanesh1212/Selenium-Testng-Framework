package tests;

import base.BaseTest;
import driver.DriverManager;
import listeners.TestListener;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.LoginPage;
import reporter.Reporter;
import dataProvider.DataProviderUtils;
import java.util.Map;

public class RegressionTest extends BaseTest {

    @Test(description = "Regression test", dataProvider = "testData", dataProviderClass = DataProviderUtils.class)
    public void sampleRegressionTest(Map<String, String> data) throws InterruptedException {


        String testDescription = data.get("TestDescription");
        String title = data.get("Title");

        WebDriver driver = DriverManager.getDriver();
        Thread.sleep(5000);
        Reporter.info("Regression test started");
        driver.get("https://www.google.com/");
        System.out.println("Title is : " + title + " "+ " Test description is : " + testDescription);
        Assert.assertEquals("123","234");
        Thread.sleep(5000);
        Assert.assertTrue(true);

    }
}
