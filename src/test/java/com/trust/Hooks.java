package com.trust;

import com.trust.constants.Platform;
import com.trust.core.DriverManager;
import com.trust.utils.PropertyHelper;
import io.appium.java_client.AppiumDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeSuite;

import java.io.IOException;
import java.util.Properties;

public class Hooks {
    protected AppiumDriver driver;
    private String envPath = "src/test/resources/config/env.properties";

    @BeforeSuite(alwaysRun = true)
    public void setup(ITestContext context) throws IOException {
        Properties props = PropertyHelper.loadProperties(envPath);
        Platform platform = Platform.valueOf((String) props.get("platform"));
        try {
            this.driver = new DriverManager().getDriver(platform);
        } catch ( Exception e) {
            e.printStackTrace();
        }
    }

    @AfterMethod(alwaysRun = true)
    public void teardown() {
        driver.quit();
    }
}
