package tests;

import base.BaseTest;
import dataProvider.DataProviderUtils;
import org.testng.annotations.Test;
import pages.LandingPage;
import pages.LoginPage;
import reporter.Reporter;

import java.util.Map;

public class SampleTest extends BaseTest {

    @Test(description = "login test", dataProvider = "testData", dataProviderClass = DataProviderUtils.class)
    public void sampleSmokeTest(Map<String, String> data){

        String username = data.get("Username");
        String password = data.get("Password");

        Reporter.info("Navigating to landing page");
        LandingPage landingPage = new LandingPage();

        //go to login page and login
        LoginPage loginPage = landingPage.goToLoginPage();
        Reporter.info("Navigated to login page", true);

        loginPage.login(username, password);
        Reporter.info("Logged into application successfully", true);

    }
}
