package pageobjects.settings.settingsmenu;

import org.openqa.selenium.WebElement;
import pagecomponents.Element;
import pageobjects.settings.SettingsAbstract;

/**
 * Created by chandan on 8/24/2015.
 */
public class ParentalControls extends SettingsAbstract {

    WebElement signInButton, label;

    public ParentalControls() {
        checkPage();
    }

    private void checkPage() {
        try {
            label = new Element().elementByXpath("//android.view.View[@content-desc='My settings']");
        } catch (Exception e) {
            signInButton = new Element().elementByXpath("//android.widget.Button[@content-desc='Sign in']");
        }
    }
}
