package pageobjects.settings.settingsmenu;

import org.openqa.selenium.WebElement;
import pagecomponents.Element;
import pageobjects.settings.SettingsAbstract;

/**
 * Created by chandan on 8/24/2015.
 */
public class ParentalControls extends SettingsAbstract {

    WebElement signInButton;

    public ParentalControls() {
        signInButton = new Element().elementByXpath("//android.widget.Button[@content-desc='Sign in']");
    }
}
