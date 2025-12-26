package tests;

import base.BaseTest;
import driver.DriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SampleTest extends BaseTest {

    @Test(description = "First sample test")
    public void sampleSmokeTest() {

        WebDriver driver = DriverManager.getDriver();
        driver.get("https://www.google.com");
        System.out.println("Sample Smoke Test executed");
        Assert.assertTrue(true);
    }
}
