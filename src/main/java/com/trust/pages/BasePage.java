package com.trust.pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    protected AppiumDriver driver;
    private Duration timeout = Duration.ofSeconds(10);

    public BasePage(AppiumDriver driver) {
        this.driver = driver;
    }

    public By backBtn = By.xpath("//android.view.View[@content-desc=\"Back\"]");

    public BasePage clickBackBtn() {
        getElement(backBtn).click();
        return this;
    }

    public void click(WebElement ele) {
        ele.click();
    }

    public WebElement getElement(By by) {
        return waitForElementToBePresent(by);
    }

    public WebElement waitForElementToBePresent(By by) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        wait.until(ExpectedConditions.presenceOfElementLocated(by));
        return driver.findElement(by);
    }

    public boolean isDisplayed(By by) {
        WebElement element = waitForElementToBePresent(by);
        return element.isDisplayed();
    }


}
