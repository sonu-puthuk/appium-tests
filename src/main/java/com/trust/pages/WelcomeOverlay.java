package com.trust.pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class WelcomeOverlay extends BasePage {
    public WelcomeOverlay(AppiumDriver driver) {
        super(driver);
    }

    private final By title = By.xpath("//android.widget.TextView[@text=\"Welcome aboard\"]");
    private final By startUsingBtn = By.xpath("//android.widget.TextView[@text=\"Start using Trust Wallet\"]");

    public boolean isLoaded() {
        waitForElementToBePresent(title);
        return getElement(title).isDisplayed();
    }

    public HomePage tapStartUsingBtn() {
        WebElement startUsingEle = waitForElementToBePresent(startUsingBtn);

        click(startUsingEle);
        return new HomePage(driver);
    }


}
