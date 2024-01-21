package com.trust.pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class CreatePasscodePage extends BasePage{
    public CreatePasscodePage(AppiumDriver driver) {
        super(driver);
    }

    private final By title = By.xpath("//android.widget.TextView[@text=\"Create passcode\"]");
    private final String dialPadNumXpath = "//android.widget.TextView[@text=\"#\"]";

    public boolean isLoaded(){
        waitForElementToBePresent(title);
        return getElement(title).isDisplayed();
    }

    public ConfirmPasscodePage setPasscode(String passcode) {
        for (char c : passcode.toCharArray()) {
            By num  = By.xpath(dialPadNumXpath.replace('#',c));
            WebElement numEle = getElement(num);
            numEle.click();
        }
        return new ConfirmPasscodePage(driver);
    }


}
