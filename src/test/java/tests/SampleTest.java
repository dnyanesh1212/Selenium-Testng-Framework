package tests;

import base.BaseTest;
import dataProvider.DataProviderUtils;
import org.testng.annotations.Test;
import pages.LoginPage;
import reporter.Reporter;

import java.util.Map;

public class SampleTest extends BaseTest {

    @Test(description = "First sample test", dataProvider = "testData", dataProviderClass = DataProviderUtils.class)
    public void sampleSmokeTest(Map<String, String> data) throws InterruptedException {


        String testDescription = data.get("TestDescription");
        String username = data.get("Username");
        String password = data.get("Password");

        Reporter.info("Navigating to login page");

        LoginPage loginPage = new LoginPage();
        loginPage.login(username, password);
        Reporter.info("Logged into application", true);

    }
}
