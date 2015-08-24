package pageobjects.mainpages;

import pagecomponents.ImageView;
import pageobjects.settings.SettingsMainPage;
import pageobjects.settings.help.HelpInfoMenu;
import pageobjects.settings.settingsmenu.SettingsSubMenuPage;

/**
 * Created by cku04 on 17/08/2015.
 */
public class HomePage extends Page {

    ImageView contextMenu, search, settings;

    public HomePage() {
        contextMenu = new ImageView("com.bskyb.skygo:id/context_menu");
        search = new ImageView("com.bskyb.skygo:id/search");
        settings = new ImageView("com.bskyb.skygo:id/more");

    }

    public MenuListPage gotToMenuListPage() {
        contextMenu.click();
        return new MenuListPage();
    }

    public SettingsMainPage gotToSettingsMainPage() {
        settings.click();
        return new SettingsMainPage();
    }

    public OnNowPage goToOnNowPage() {
        gotToMenuListPage().goToOnNowPage();
        return new OnNowPage();
    }

    public CatchUpPage goToCatchUpPage() {
        gotToMenuListPage().goToCatchUpPage();
        return new CatchUpPage();
    }

    public SkyBoxSetsPage goToSkyBoxSetsPage() {
        gotToMenuListPage().goToSkyBoxSetsPage();
        return new SkyBoxSetsPage();
    }

    public SkyMoviesPage goToSkyMoviesPage() {
        gotToMenuListPage().goToSkyMoviesPage();
        return new SkyMoviesPage();
    }

    public DownloadsPage goToDownloadsPage() {
        gotToMenuListPage().goToDownloadsPage();
        return new DownloadsPage();
    }

    public SettingsSubMenuPage goToSettingsSubMenu() {
        gotToSettingsMainPage().goToSettingsSubMenu();
        return new SettingsSubMenuPage();
    }

    public HelpInfoMenu goToHelpInfoMenu() {
        gotToSettingsMainPage().goToHelpInfoMenu();
        return new HelpInfoMenu();
    }

}
