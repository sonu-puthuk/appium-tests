package com.trust.pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class SelectNetworkPage extends BasePage {
    private final By title = By.xpath("//android.widget.TextView[@text=\"Select network\"]");
    private final By searchField = By.xpath("//android.widget.TextView[@text=\"Search\"]");
    private final String networkXpath = "//android.widget.TextView[@text=\"###\"]";

    public SelectNetworkPage(AppiumDriver driver) {
        super(driver);
    }

    public boolean isLoaded() {
        waitForElementToBePresent(title);
        return getElement(title).isDisplayed();
    }

    public RestoreWalletPage selectNetwork(String network) {
        WebElement networkEle = getNetworkElement(network);
        networkEle.click();

        return new RestoreWalletPage(driver);
    }

    public RestoreWalletPage selectMultiCoinWallet() {
        return selectNetwork("Multi-coin wallet");
    }

    private WebElement getNetworkElement(String network) {
        By num = By.xpath(networkXpath.replace("###", network));
        return getElement(num);
    }

}
