package com.trust.pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class StartPage extends BasePage {
    private final By popularTokensTitle = By.xpath("//android.widget.TextView[@text=\"Popular tokens\"]");
    private final By createNewWalletBtn = By.xpath("//android.widget.TextView[@text=\"Create new wallet\"]");
    private final By addExistingWalletBtn = By.xpath("//android.widget.TextView[@text=\"Add existing wallet\"]");

    public StartPage(AppiumDriver driver) {
        super(driver);
    }

    public boolean isLoaded() {
        waitForElementToBePresent(popularTokensTitle);
        return getElement(popularTokensTitle).isDisplayed();
    }

    public BackupPage tapCreateNewWallet() {
        WebElement createNewElem = waitForElementToBePresent(createNewWalletBtn);

        click(createNewElem);
        return new BackupPage(driver);
    }

    public AddExistingWalletPage tapAddExistingWallet() {
        WebElement addExisting = waitForElementToBePresent(addExistingWalletBtn);

        click(addExisting);
        return new AddExistingWalletPage(driver);
    }


}
