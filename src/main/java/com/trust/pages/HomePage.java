package com.trust.pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class HomePage extends BasePage{
    public HomePage(AppiumDriver driver) {
        super(driver);
    }

    private final By title = By.xpath("(//android.widget.TextView[@text=\"Home\"])[1]");


    public boolean isLoaded(){
        waitForElementToBePresent(title);
        return getElement(title).isDisplayed();
    }


}
