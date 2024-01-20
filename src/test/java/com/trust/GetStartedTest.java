package com.trust;

import com.trust.page.GetStarted;
import com.trust.page.Home;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GetStartedTest extends Hooks {
    @Test()
    public void testGetStartedPage() {
        Home home = new GetStarted(driver).tapGetStarted();
        Assert.assertTrue(home.isLoaded());
    }

}
