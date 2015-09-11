package pageobjects.mainpages;

import org.openqa.selenium.WebElement;
import pagecomponents.ImageView;
import pageobjects.settings.SettingsMainPage;
import pageobjects.settings.help.HelpInfoMenu;
import pageobjects.settings.settingsmenu.SettingsSubMenuPage;

/**
 * Created by cku04 on 17/08/2015.
 */
public class HomePage extends Page {

    ImageView contextMenu, search, settings;
    WebElement splashPage;


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
        log.info("");
        settings.click();
        return new SettingsMainPage();
    }

    public OnNowPage goToOnNowPage() {
        log.info("");
        gotToMenuListPage().goToOnNowPage();
        return new OnNowPage();
    }

    public CatchUpPage goToCatchUpPage() {
        log.info("");
        gotToMenuListPage().goToCatchUpPage();
        return new CatchUpPage();
    }

    public SkyBoxSetsPage goToSkyBoxSetsPage() {
        log.info("");
        gotToMenuListPage().goToSkyBoxSetsPage();
        return new SkyBoxSetsPage();
    }

    public SkyMoviesPage goToSkyMoviesPage() {
        log.info("");
        gotToMenuListPage().goToSkyMoviesPage();
        return new SkyMoviesPage();
    }

    public DownloadsPage goToDownloadsPage() {
        log.info("");
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

    public SearchPage gotToSearch() {
        search.click();
        return new SearchPage();
    }

}
