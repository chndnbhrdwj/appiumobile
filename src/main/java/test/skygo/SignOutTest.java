package test.skygo;

import core.Testcase;
import org.junit.Assert;
import org.junit.Test;
import pageobjects.mainpages.HomePage;

/**
 * Created by cku04 on 04/09/2015.
 */
public class SignOutTest extends Testcase {

    @Test
    public void signOut() {
        new HomePage()
                .gotToSettingsMainPage()
                .clickSignOut()
                .signOut();
        Assert.assertTrue("Sign Out was not successful.",
                new HomePage()
                        .gotToSettingsMainPage()
                        .isSignInDisplayed());
    }
}
