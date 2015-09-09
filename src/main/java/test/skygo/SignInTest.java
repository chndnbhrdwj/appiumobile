package test.skygo;

import core.Testcase;
import org.junit.Assert;
import org.junit.Test;
import pageobjects.mainpages.HomePage;

/**
 * Created by cku04 on 04/09/2015.
 */
public class SignInTest extends Testcase {

    @Test
    public void signIn() {
        new HomePage()
                .gotToSettingsMainPage()
                .clickSignIn()
                .signIn(props.getPropertyValue("Username"),
                        props.getPropertyValue("Password"));
        Assert.assertTrue("Sign In was not successful.",
                new HomePage()
                        .gotToSettingsMainPage()
                        .isSignOutDisplayed());
    }
}
