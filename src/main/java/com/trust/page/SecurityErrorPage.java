package com.trust.page;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class SecurityErrorPage extends BasePage {
    private final By errorMsg = By.xpath("//android.widget.TextView[@text=\"DEVICE SECURITY COMPROMISED\"]");
    private final By ok = By.xpath("//android.widget.TextView[@text=\"OK\"]");

    public SecurityErrorPage(AppiumDriver driver) {
        super(driver);
    }

    public GetStartedPage tapOK() {
        if (getElement(errorMsg).isDisplayed()) {
            WebElement okEle = getElement(ok);
            waitForElementToBeVisible(okEle);
            click(okEle);
        }

        return new GetStartedPage(driver);
    }

}
