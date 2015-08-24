package pageobjects;

import pagecomponents.TextView;

/**
 * Created by chandan on 8/24/2015.
 */
public class SettingsSubMenuPage extends Page {

    TextView manageMyDevices, parentalControls, manageMySkyID, networkPreferences;

    public SettingsSubMenuPage() {
        manageMyDevices = new TextView("Manage my Devices");
        parentalControls = new TextView("Parental Controls");
        manageMySkyID = new TextView("Manage my Sky iD");
        networkPreferences = new TextView("Network Preferences");
    }

    public ManageMyDevicesPage goToManageDevices() {
        manageMyDevices.click();
        return new ManageMyDevicesPage();
    }
}
