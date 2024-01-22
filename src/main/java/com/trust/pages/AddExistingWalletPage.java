package com.trust.pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class AddExistingWalletPage extends BasePage {
    private final By title = By.xpath("//android.widget.TextView[@text=\"Add existing wallet\"]");
    private final By secretPhraseBtn = By.xpath("//android.widget.TextView[@text=\"Secret phrase\"]");
    private final By googleDriveBackupBtn = By.xpath("//android.widget.TextView[@text=\"Google Drive backup\"]");
    private final By viewOnlyWalletBtn = By.xpath("//android.widget.TextView[@text=\"View-only wallet\"]");

    public AddExistingWalletPage(AppiumDriver driver) {
        super(driver);
    }

    public boolean isLoaded() {
        waitForElementToBePresent(title);
        return getElement(title).isDisplayed();
    }

    public SelectNetworkPage tapSecretPhraseBtn() {
        WebElement secretEle = waitForElementToBePresent(secretPhraseBtn);

        click(secretEle);
        return new SelectNetworkPage(driver);
    }

    public SelectNetworkPage tapViewOnlyWalletBtn() {
        WebElement viewOnlyEle = waitForElementToBePresent(viewOnlyWalletBtn);

        click(viewOnlyEle);
        return new SelectNetworkPage(driver);
    }

}
