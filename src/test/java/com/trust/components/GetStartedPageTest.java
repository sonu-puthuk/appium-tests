package com.trust.components;

import com.trust.hooks.Hooks;
import com.trust.pages.GetStartedPage;
import com.trust.pages.StartPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GetStartedPageTest extends Hooks {
    @Test()
    public void testGetStartedPage() {
        StartPage startPage = new GetStartedPage(driver).tapGetStarted();
        Assert.assertTrue(startPage.isLoaded());
    }

}
