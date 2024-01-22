package com.trust.pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class CreatePasscodePage extends BasePage {
    public CreatePasscodePage(AppiumDriver driver) {
        super(driver);
    }

    private final By title = By.xpath("//android.widget.TextView[@text=\"Create passcode\"]");
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

    public ConfirmPasscodePage setPasscode(String passcode) {
        for (char c : passcode.toCharArray()) {
            WebElement numEle = getNumPadElement(c);
            numEle.click();
        }
        return new ConfirmPasscodePage(driver);
    }

    public CreatePasscodePage validatePage() {
        Assert.assertTrue(isLoaded());
        Assert.assertTrue(isNumberPadLoaded());

        return this;
    }

}
