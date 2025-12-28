package tests;

import base.BaseTest;
import driver.DriverManager;
import listeners.TestListener;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.LoginPage;
import utils.Screenshotutils;

@Listeners(TestListener.class)
public class SampleTest extends BaseTest {

    @Test(description = "First sample test")
    public void sampleSmokeTest() throws InterruptedException {

        WebDriver driver = DriverManager.getDriver();
        System.out.println("Sample Smoke Test executed");
        Thread.sleep(5000);
        Assert.assertTrue(true);

        LoginPage loginPage = new LoginPage();
        loginPage.login("dnyana@gmail.com", "Abc@123");
        Thread.sleep(5000);
    }
}
