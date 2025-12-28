package tests;

import base.BaseTest;
import driver.DriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import reporter.Reporter;

public class SampleTest extends BaseTest {

    @Test(description = "First sample test")
    public void sampleSmokeTest() throws InterruptedException {

        Reporter.info("Navigating to login page");

        LoginPage loginPage = new LoginPage();
        loginPage.login("dnyana@gmail.com", "Abc@123");
        Reporter.info("Logged into application", true);
//        Thread.sleep(5000);
    }
}
