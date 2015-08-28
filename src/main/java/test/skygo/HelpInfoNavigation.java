package test.skygo;

import core.Testcase;
import org.junit.Test;
import pageobjects.mainpages.HomePage;

/**
 * Created by cku04 on 17/08/2015.
 */
public class HelpInfoNavigation extends Testcase {

    String assets;

    @Test
    public void testIt() {
        verifyHelpInfoNavigation();
    }


    public void verifyHelpInfoNavigation() {
        new HomePage()
                .goToHelpInfoMenu()
                .goToFaqs()
                .goBackToOnNow()
                .goToHelpInfoMenu()
                .goToMoreSkyGoExtra()
                .goBackToOnNow()
                .goToHelpInfoMenu()
                .goToTermsConditions()
                .goBackToOnNow()
                .goToHelpInfoMenu()
                .goToPrivacyCookies()
                .goBackToOnNow()
                .goToHelpInfoMenu()
                .goToLicenses()
                .goBackToOnNow()
                .goToHelpInfoMenu()
                .goToAbout()
                .goBackToOnNow()
                .goToHelpInfoMenu()
                .goToSkyUKApps()
                .goBackToOnNow();
    }
}
