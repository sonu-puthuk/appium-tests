package com.trust.e2e;

import com.trust.hooks.Hooks;
import com.trust.pages.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateNewWalletTest extends Hooks {
    @Test(groups = {"smoke", "e2e"})
    public void testNewWalletWithoutBackup() {
        StartPage startPage = new GetStartedPage(driver).tapGetStarted();
        Assert.assertTrue(startPage.isLoaded());

        BackupPage backupPage = startPage.tapCreateNewWallet();
        backupPage.validatePage();

        CreatePasscodePage createPasscodePage = backupPage.tapSkip();
        createPasscodePage.validatePage();

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
