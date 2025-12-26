package base;

import driver.DriverFactory;
import driver.DriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class BaseTest {

    WebDriver driver=null;

    @Parameters("browser")
    @BeforeMethod(alwaysRun = true)
    public void setUp(String browser){

        driver = DriverFactory.createDriver(browser);
        DriverManager.setDriver(driver);
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown(){

        driver = DriverManager.getDriver();
        if (driver!=null){
            driver.quit();
            DriverManager.removeDriver();
        }
    }
}
