package com.trust.core;

import com.trust.constants.Platform;
import com.trust.utils.CapabilityHelper;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;

public class DriverManager {
    private static AppiumDriver driver;
    String APPIUM_SERVER_URL = "http://localhost:4723";

    public AppiumDriver getDriver(Platform platform) throws Exception {
        return switch (platform) {
            case ANDROID -> getAndroidDriver();
            case IOS -> getIOSDriver();
        };
    }

    public AppiumDriver getDriver(Map<String, String> map) {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities(map);

        try {
            driver = new AppiumDriver(
                    new URL(APPIUM_SERVER_URL), desiredCapabilities);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        return driver;
    }

    private AppiumDriver getAndroidDriver() throws IOException {
        Map<String, String> map = CapabilityHelper.getCapabilitiesMap("src/test/resources/capabilities/android.properties");
        return getDriver(map);
    }

    public AppiumDriver getIOSDriver() throws IOException {
        Map<String, String> map = CapabilityHelper.getCapabilitiesMap("src/test/resources/capabilities/ios.properties");
        return getDriver(map);
    }


}
