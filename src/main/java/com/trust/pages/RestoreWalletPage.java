package com.trust.pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class RestoreWalletPage extends BasePage {
    private final By title = By.xpath("//android.widget.TextView[@text=\"Wallet name\"]");
    private final By walletNameField = By.xpath("//android.widget.ScrollView/android.widget.EditText[1]");
    private final By secretPhraseField = By.xpath("//android.widget.ScrollView/android.widget.EditText[2]");
    private final By pasteBtn = By.xpath("//android.widget.TextView[@text=\"Paste\"]");
    private final By restoreWalletBtn = By.xpath("//android.widget.TextView[@text=\"Restore wallet\"]");
    private final By whatIsASecretPhraseBtn = By.xpath("//android.widget.TextView[@text=\"What is a secret phrase?\"]");
    private final By backBtn = By.xpath("//androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View/android.widget.Button[1]");
    private final By qrCodeBtn = By.xpath("//androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View/android.widget.Button");


    public RestoreWalletPage(AppiumDriver driver) {
        super(driver);
    }

    public boolean isLoaded() {
        waitForElementToBePresent(title);
        return getElement(title).isDisplayed();
    }

    public CreatePasscodePage tapRestoreBtn() {
        // TODO workaround for driver.hidekeyboard(). Need to fix properly
        waitForElementToBePresent(qrCodeBtn).click();
        waitForElementToBePresent(backBtn).click();
        WebElement restoreEle = waitForElementToBePresent(restoreWalletBtn);

        click(restoreEle);
        return new CreatePasscodePage(driver);
    }

    public AddExistingWalletPage setWalletName(String name) {
        WebElement walletEle = waitForElementToBePresent(walletNameField);

        walletEle.clear();
        walletEle.sendKeys(name);
        return new AddExistingWalletPage(driver);
    }

    public AddExistingWalletPage setSecretPhrase(String phrase) {
        WebElement secretEle = waitForElementToBePresent(secretPhraseField);

        secretEle.sendKeys(phrase);
        return new AddExistingWalletPage(driver);
    }

}
