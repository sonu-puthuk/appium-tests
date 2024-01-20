
package com.trust.utils;

import com.trust.core.DriverManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.IOException;

import java.io.File;
import java.util.Date;

public class ScreenshotHelper implements ITestListener {
    @Override
    public void onTestFailure(ITestResult tr) {
        captureScreenShot(tr, "fail");
    }

    public void captureScreenShot(ITestResult result, String status) {
        String destDir = status.equalsIgnoreCase("fail")?"build/reports/screenshots/fail":"screenshots/pass";
        File scrFile = ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.FILE);

        new File(destDir).mkdirs();
        String destFile = new Date().getTime() + ".png";

        try {
            FileHandler.copy(scrFile, new File(destDir + "/" + destFile));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
