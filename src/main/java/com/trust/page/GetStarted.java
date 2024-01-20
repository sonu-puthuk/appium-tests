package com.trust.page;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class GetStarted extends BasePage {
    private final By getStarted = By.className("android.widget.Button");

    public GetStarted(AppiumDriver driver) {
        super(driver);
    }

    public Home tapGetStarted() {
        WebElement getStartedElem = getElement(getStarted);
        waitForElementToBeVisible(getStartedElem);

        click(getStartedElem);

        return new Home(driver);
    }

}
