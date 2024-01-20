package com.trust.page;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class Home extends BasePage{
    public Home(AppiumDriver driver) {
        super(driver);
    }

    private final By createNewWallet = By.linkText("Create new wallet");
    private final By addExistingWallet = By.linkText("Add existing wallet");

    public boolean isLoaded(){
        waitForElementToBeVisible(getElement(createNewWallet));
        return getElement(createNewWallet).isDisplayed();
    }


}
