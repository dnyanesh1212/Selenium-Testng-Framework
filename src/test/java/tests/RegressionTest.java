package tests;

import base.BaseTest;
import driver.DriverManager;
import listeners.TestListener;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.LoginPage;

@Listeners(TestListener.class)
public class RegressionTest extends BaseTest {

    @Test(description = "First sample test")
    public void sampleRegressionTest() throws InterruptedException {

        WebDriver driver = DriverManager.getDriver();
        System.out.println("Sample Smoke Test executed");
        Thread.sleep(5000);
        Assert.assertTrue(true);
        Thread.sleep(5000);

    }
}
