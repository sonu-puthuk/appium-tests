package com.trust.components;

import com.trust.hooks.Hooks;
import com.trust.pages.BackupPage;
import com.trust.pages.GetStartedPage;
import com.trust.pages.StartPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BackupPageTest extends Hooks {
    @Test(groups = {"regression"})
    public void testBackupPageLoaded() {
        StartPage startPage = new GetStartedPage(driver).tapGetStarted();
        Assert.assertTrue(startPage.isLoaded());

        BackupPage backupPage = startPage.tapCreateNewWallet();
        backupPage.validatePage();
    }


}
