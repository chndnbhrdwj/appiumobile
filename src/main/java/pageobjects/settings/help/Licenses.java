package pageobjects.settings.help;

import org.openqa.selenium.WebElement;
import pagecomponents.Element;
import pageobjects.settings.SettingsAbstract;

/**
 * Created by chandan on 8/24/2015.
 */
public class Licenses extends SettingsAbstract {

    WebElement apacheLicense;

    public Licenses() {
        apacheLicense = new Element().elementByXpath("//android.view.View[@content-desc='Apache licence v.2.0']");
    }
}
