package com.trust.e2e;

import com.trust.hooks.Hooks;
import com.trust.pages.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddExistingWalletTest extends Hooks {
    @Test(groups = {"smoke", "e2e"})
    public void testAddExistingWallet() {
        StartPage startPage = new GetStartedPage(driver).tapGetStarted();
        Assert.assertTrue(startPage.isLoaded());

        AddExistingWalletPage addExistingWalletPage = startPage.tapAddExistingWallet();
        Assert.assertTrue(addExistingWalletPage.isLoaded());

        SelectNetworkPage selectNetworkPage = addExistingWalletPage.tapSecretPhraseBtn();
        Assert.assertTrue(selectNetworkPage.isLoaded());

        RestoreWalletPage restoreWalletPage = selectNetworkPage.selectMultiCoinWallet();
        Assert.assertTrue(restoreWalletPage.isLoaded());

        restoreWalletPage.setWalletName("Test wallet");
        //TODO source from a test data file in resources
        restoreWalletPage.setSecretPhrase("embark month ramp better topple snake barrel pulp tent crop bomb blanket");
        CreatePasscodePage createPasscodePage = restoreWalletPage.tapRestoreBtn();

        ConfirmPasscodePage confirmPasscodePage = createPasscodePage.setPasscode("111111");
        confirmPasscodePage.validatePage();

        WelcomeOverlay welcomeOverlay = confirmPasscodePage.setPasscode("111111");
        welcomeOverlay.validatePage();

        HomePage homePage = welcomeOverlay.tapStartUsingBtn();
        homePage.validatePage();
        Assert.assertEquals("0.00", homePage.getBalance().get("amount"));
        Assert.assertEquals("$", homePage.getBalance().get("currency"));
    }
}
