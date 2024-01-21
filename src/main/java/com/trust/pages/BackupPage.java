package com.trust.pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class BackupPage extends BasePage {
    public BackupPage(AppiumDriver driver) {
        super(driver);
    }

    private final By title = By.xpath("//android.widget.TextView[@text=\"Backup\"]");
    private final By manualBtn = By.xpath("//android.widget.TextView[@text=\"Back up manually\"]");
    private final By googleDriveBtn = By.xpath("//android.widget.TextView[@text=\"Back up to Google Drive\"]");
    private final By skipBtn = By.xpath("//android.widget.TextView[@text=\"SKIP\"]");

    public boolean isLoaded() {
        waitForElementToBePresent(title);
        return getElement(title).isDisplayed();
    }

    public CreatePasscodePage tapSkip() {
        WebElement skipEle = waitForElementToBePresent(skipBtn);

        click(skipEle);
        return new CreatePasscodePage(driver);
    }

    public BackupPage validatePage() {
        Assert.assertTrue(isLoaded());
        Assert.assertTrue(isDisplayed(manualBtn));
        Assert.assertTrue(isDisplayed(googleDriveBtn));
        Assert.assertTrue(isDisplayed(skipBtn));
        Assert.assertTrue(isDisplayed(backBtn));
        return this;
    }

}
