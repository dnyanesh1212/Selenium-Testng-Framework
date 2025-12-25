package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SampleTest {
    @Test
    public void sampleSmokeTest() {
        System.out.println("Sample Smoke Test executed");
        Assert.assertTrue(true);
    }
}
