package com.trust;

import com.trust.page.GetStartedPage;
import com.trust.page.HomePage;
import com.trust.utils.ScreenshotHelper;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(ScreenshotHelper.class)
public class GetStartedPageTest extends Hooks {
    @Test()
    public void testGetStartedPage() {
        HomePage homePage = new GetStartedPage(driver).tapGetStarted();
        Assert.assertTrue(homePage.isLoaded());
    }

}
