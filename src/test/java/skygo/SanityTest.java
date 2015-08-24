package skygo;

import org.junit.Test;
import pageobjects.HomePage;

/**
 * Created by cku04 on 17/08/2015.
 */
public class SanityTest{

    @Test
    public void testIt() {
        verifyNavigation();
        verifySettingsNavigation();
    }

    public void testVideoPlayer() {
        new HomePage()
                .gotToMenuListPage()
                .goToSkyMoviesPage()
                .clickShowcaseItem()
                .watchProgram()
                .videoViewDisplayed();
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
                .goToSettingsSubMenu()
                .goToManageDevices()
                .goBackToOnNow()
                .gotToSettingsMainPage();
    }


}
