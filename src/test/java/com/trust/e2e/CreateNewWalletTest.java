package com.trust.e2e;

import com.trust.hooks.Hooks;
import com.trust.pages.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateNewWalletTest extends Hooks {
    @Test()
    public void testNewWalletWithoutBackup() {
        StartPage startPage = new GetStartedPage(driver).tapGetStarted();
        Assert.assertTrue(startPage.isLoaded());

        BackupPage backupPage = startPage.tapCreateNewWallet();
        Assert.assertTrue(backupPage.isLoaded());

        CreatePasscodePage createPasscodePage = backupPage.tapSkip();
        Assert.assertTrue(createPasscodePage.isLoaded());

        ConfirmPasscodePage confirmPasscodePage = createPasscodePage.setPasscode("111111");
        Assert.assertTrue(confirmPasscodePage.isLoaded());

        WelcomeOverlay welcomeOverlay = confirmPasscodePage.setPasscode("111111");
        Assert.assertTrue(welcomeOverlay.isLoaded());

        HomePage homePage = welcomeOverlay.tapStartUsingBtn();
        Assert.assertTrue(homePage.isLoaded());
    }
}
