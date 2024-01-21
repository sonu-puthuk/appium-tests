package com.trust.pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class SecurityErrorPage extends BasePage {
    private final By title = By.xpath("//android.widget.TextView[@text=\"DEVICE SECURITY COMPROMISED\"]");
    private final By okBtn = By.xpath("//android.widget.TextView[@text=\"OK\"]");

    public SecurityErrorPage(AppiumDriver driver) {
        super(driver);
    }

    public GetStartedPage tapOK() {
        if (getElement(title).isDisplayed()) {
            WebElement okEle = waitForElementToBePresent(okBtn);
            click(okEle);
        }

        return new GetStartedPage(driver);
    }

}
