package utils;

import driver.DriverManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Screenshotutils {

    private Screenshotutils() {

    }

    public static String takeScreenshot(String testFolderName){

        String baseDir = System.getProperty("user.dir") + "/reports/";
        String screenshotDir = baseDir + testFolderName + "/screenshots/";

        TakesScreenshot ts = (TakesScreenshot) DriverManager.getDriver();

        File source = ts.getScreenshotAs(OutputType.FILE);

        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmssSSS").format(new Date());

        String filePath = screenshotDir + "failure_" + timestamp + ".png";

        File destination = new File(filePath);

        try{

            Files.createDirectories(destination.getParentFile().toPath());
            Files.copy(source.toPath(), destination.toPath());
        }
        catch (IOException e){

            throw new RuntimeException("Failed to capture screenshot..!!", e);
        }

        return filePath;
    }

}
