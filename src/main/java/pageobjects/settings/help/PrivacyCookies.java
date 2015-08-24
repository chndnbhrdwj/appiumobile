package pageobjects.settings.help;

import org.openqa.selenium.WebElement;
import pagecomponents.Element;
import pageobjects.settings.SettingsAbstract;

/**
 * Created by chandan on 8/24/2015.
 */
public class PrivacyCookies extends SettingsAbstract {

    WebElement privacyNotice;

    public PrivacyCookies() {
        privacyNotice = new Element().elementByXpath("//android.view.View[@content-desc='Sky.com Privacy Notice']");
    }
}
