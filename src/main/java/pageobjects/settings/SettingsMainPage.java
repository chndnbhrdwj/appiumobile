package pageobjects.settings;

import pagecomponents.TextView;
import pageobjects.settings.help.HelpInfoMenu;
import pageobjects.settings.settingsmenu.SettingsSubMenuPage;

/**
 * Created by chandan on 8/24/2015.
 */
public class SettingsMainPage extends SettingsAbstract {

    TextView settings, help, skyAccount, config;

    public SettingsMainPage() {
        settings = new TextView("Settings");
        help = new TextView("Help & Info");
        skyAccount = new TextView("Sky Account");
//        config = new TextView("Select config");
    }

    public SettingsSubMenuPage goToSettingsSubMenu() {
        settings.click();
        return new SettingsSubMenuPage();
    }

    public HelpInfoMenu goToHelpInfoMenu() {
        help.click();
        return new HelpInfoMenu();
    }

    public SkyAccount goToSkyAccount() {
        skyAccount.click();
        return new SkyAccount();
    }

    //Not available on signed build
/*
    public SelectConfig goToConfig() {
        config.click();
        return new SelectConfig();
    }
*/



}
