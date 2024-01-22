package com.trust.pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.testng.Assert;

import java.util.Map;

public class HomePage extends BasePage {
    private final By title = By.xpath("(//android.widget.TextView[@text=\"Home\"])[1]");
    private final By searchField = By.xpath("//android.widget.TextView[@text=\"Search\"]");
    private final By mainBalance = By.xpath("//android.widget.TextView[@resource-id=\"main_balance\"]");
    private final By sendBtn = By.xpath("//android.widget.TextView[@text=\"Send\"]");
    private final By buyBtn = By.xpath("//android.widget.TextView[@text=\"Buy\"]");
    private final By receiveBtn = By.xpath("//android.widget.TextView[@text=\"Receive\"]");
    private final By earnBtn = By.xpath("//android.widget.TextView[@text=\"Earn\"]");

    private final By cryptoSection = By.xpath("//android.widget.TextView[@text=\"Crypto\"]");
    private final By nftSection = By.xpath("//android.widget.TextView[@text=\"NFTs\"]");

    private final By homeBtn = By.xpath("(//android.widget.TextView[@text=\"Home\"])[2]");
    private final By swapBtn = By.xpath("//android.widget.TextView[@text=\"Swap\"]");
    private final By discoverBtn = By.xpath("//android.widget.TextView[@text=\"Discover\"]");
    private final By browserBtn = By.xpath("//android.widget.TextView[@text=\"Browser\"]");


    public HomePage(AppiumDriver driver) {
        super(driver);
    }

    public boolean isLoaded() {
        waitForElementToBePresent(title);
        return getElement(title).isDisplayed();
    }

    private boolean isTransactSectionDisplayed() {
        return isDisplayed(sendBtn) && isDisplayed(receiveBtn)
                && isDisplayed(buyBtn) && isDisplayed(earnBtn);
    }

    private boolean isCryptoNFTAssetSectionDisplayed() {
        return isDisplayed(cryptoSection) && isDisplayed(nftSection);
    }

    private boolean isFooterDisplayed() {
        return isDisplayed(homeBtn) && isDisplayed(browserBtn)
                && isDisplayed(discoverBtn) && isDisplayed(swapBtn);
    }

    public HomePage validatePage() {
        Assert.assertTrue(isTransactSectionDisplayed());
        Assert.assertTrue(isCryptoNFTAssetSectionDisplayed());
        Assert.assertTrue(isFooterDisplayed());
        Assert.assertTrue(isDisplayed(searchField));
        Assert.assertTrue(isDisplayed(mainBalance));
        return this;
    }

    public Map<String, String> getBalance() {
        String balance = getElement(mainBalance).getText();
        String currency = balance.substring(0, 1);
        String amount = balance.substring(1);
        return Map.of("currency", currency, "amount", amount);
    }

}
