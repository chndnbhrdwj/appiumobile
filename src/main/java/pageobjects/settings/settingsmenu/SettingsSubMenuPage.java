package pageobjects.settings.settingsmenu;

import pagecomponents.TextView;
import pageobjects.settings.SettingsAbstract;

/**
 * Created by chandan on 8/24/2015.
 */
public class SettingsSubMenuPage extends SettingsAbstract {

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

    public ParentalControls goToParentalControls() {
        parentalControls.click();
        return new ParentalControls();
    }

    public ManageMySkyId goToManageMySkyId() {
        manageMySkyID.click();
        return new ManageMySkyId();
    }

    public NetworkPreferencesPage goToNetworkPreferences() {
        networkPreferences.click();
        return new NetworkPreferencesPage();
    }
}
