package com.trust.page;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class Home extends BasePage{
    public Home(AppiumDriver driver) {
        super(driver);
    }

    private final By popularTokens = By.xpath("//android.widget.TextView[@text=\"Popular tokens\"]");
    private final By createNewWallet = By.xpath("//android.widget.TextView[@text=\"Create new wallet\"]");
    private final By addExistingWallet = By.xpath("//android.widget.TextView[@text=\"Add existing wallet\"]");

    public boolean isLoaded(){
        waitForElementToBeVisible(getElement(popularTokens));
        return getElement(popularTokens).isDisplayed();
    }


}
