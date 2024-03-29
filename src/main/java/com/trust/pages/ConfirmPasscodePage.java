package com.trust.pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class ConfirmPasscodePage extends BasePage {
    public ConfirmPasscodePage(AppiumDriver driver) {
        super(driver);
    }

    private final By title = By.xpath("//android.widget.TextView[@text=\"Confirm passcode\"]");
    private final String dialPadNumXpath = "//android.widget.TextView[@text=\"#\"]";

    public boolean isLoaded() {
        waitForElementToBePresent(title);
        return getElement(title).isDisplayed();
    }

    private boolean isNumberPadLoaded(){
        return getNumPadElement('1').isDisplayed();
    }
    private WebElement getNumPadElement(char c){
        By num = By.xpath(dialPadNumXpath.replace('#', c));
        return getElement(num);
    }

    public WelcomeOverlay setPasscode(String passcode) {
        for (char c : passcode.toCharArray()) {
            WebElement numEle = getNumPadElement(c);
            numEle.click();
        }
        return new WelcomeOverlay(driver);
    }

    public ConfirmPasscodePage validatePage() {
        Assert.assertTrue(isLoaded());
        Assert.assertTrue(isNumberPadLoaded());

        return this;
    }


}
