package test.skygo;

import core.Testcase;
import org.junit.Test;
import pageobjects.mainpages.HomePage;
import tools.StackTraceInfo;

/**
 * Created by cku04 on 17/08/2015.
 */
public class SettingsNavigation extends Testcase {

    String assets;

    @Test
    public void testIt() {
        verifyNavigation();
        verifySettingsSubMenuNavigation();
        verifySettingsNavigation();
    }

    public void verifySettingsNavigation() {
        log.info(StackTraceInfo.getCurrentMethodName());
        new HomePage()
                .gotToSettingsMainPage()
                .goToSkyAccount()
                .goBackToOnNow()
                .gotToSettingsMainPage()
                        //.goToConfig()
                .goBackToOnNow();
    }

    public void verifySettingsSubMenuNavigation() {
        log.info(StackTraceInfo.getCurrentMethodName());
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

    public void verifyNavigation() {
        log.info(StackTraceInfo.getCurrentMethodName());
        new HomePage()
                .goToCatchUpPage()
                .goToSkyBoxSetsPage()
                .goToSkyMoviesPage()
                .goToDownloadsPage()
                .goToOnNowPage();
    }

}
