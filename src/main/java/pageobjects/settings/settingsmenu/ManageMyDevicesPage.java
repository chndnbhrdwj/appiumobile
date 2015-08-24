package pageobjects.settings.settingsmenu;

import org.openqa.selenium.WebElement;
import pagecomponents.Element;
import pageobjects.settings.SettingsAbstract;

/**
 * Created by chandan on 8/24/2015.
 */
public class ManageMyDevicesPage extends SettingsAbstract {

    WebElement label;

    public ManageMyDevicesPage() {
        label = new Element().elementByXpath("//android.view.View[@content-desc='Manage your devices']");
    }

}
