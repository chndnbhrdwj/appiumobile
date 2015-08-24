package skygo;

import org.junit.Test;
import pageobjects.mainpages.HomePage;
import pageobjects.mainpages.OnNowPage;

/**
 * Created by cku04 on 17/08/2015.
 */
public class SanityTest extends AbstractTest {

    @Test
    public void testIt() {
        verifyNavigation();
        verifyHelpInfoNavigation();
        verifySettingsSubMenuNavigation();
        verifySettingsNavigation();
        verifyVodVideoPlayer();
    }

    public void verifyVodVideoPlayer() {
        new OnNowPage()
                .goToSkyMoviesPage()
                .clickShowcaseItem()
                .watchProgram()
                .videoViewDisplayed()
                .backToProgramDetails()
                .goToOnNowPage()
                .clickShowcaseItem()
                .watchProgram()
                .videoViewDisplayed()
                .backToProgramDetails()
                .goToOnNowPage();
    }

    public void verifyNavigation() {
        new HomePage()
                .goToCatchUpPage()
                .goToSkyBoxSetsPage()
                .goToSkyMoviesPage()
                .goToDownloadsPage()
                .goToOnNowPage();
    }

    public void verifySettingsNavigation() {
        new HomePage()
                .gotToSettingsMainPage()
                .goToSkyAccount()
                .goBackToOnNow()
                .gotToSettingsMainPage()
                .goToConfig()
                .goBackToOnNow();
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

    public void verifySettingsSubMenuNavigation() {
        new HomePage()
                .goToSettingsSubMenu()
                .goToManageDevices()
                .goBackToOnNow()
                .goToSettingsSubMenu()
                .goToManageMySkyId()
                .goBackToOnNow()
                .goToSettingsSubMenu()
                .goToParentalControls()
                .goBackToOnNow()
                .goToSettingsSubMenu()
                .goToNetworkPreferences()
                .goBackToOnNow();
    }
}
