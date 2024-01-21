package com.trust.pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class GetStartedPage extends BasePage {
    private final By getStartedBtn = By.className("android.widget.Button");

    public GetStartedPage(AppiumDriver driver) {
        super(driver);
    }

    public StartPage tapGetStarted() {
        WebElement getStartedElem = waitForElementToBePresent(getStartedBtn);

        click(getStartedElem);
        return new StartPage(driver);
    }

}
