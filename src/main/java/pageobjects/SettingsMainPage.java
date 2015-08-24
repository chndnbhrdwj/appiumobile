package pageobjects;

import pagecomponents.TextView;

/**
 * Created by chandan on 8/24/2015.
 */
public class SettingsMainPage extends Page {

    TextView settings, help, skyAccount, config;

    public SettingsMainPage() {
        settings = new TextView("Settings");
        help = new TextView("Help & Info");
        skyAccount = new TextView("Sky Account");
        config = new TextView("Select config");
    }

    public SettingsSubMenuPage goToSettingsSubMenu() {
        settings.click();
        return new SettingsSubMenuPage();
    }


}
