package pageobjects.settings.settingsmenu;

import org.openqa.selenium.WebElement;
import pagecomponents.Element;
import pageobjects.mainpages.SignIn;
import pageobjects.settings.SettingsAbstract;

/**
 * Created by chandan on 8/24/2015.
 */
public class ParentalControls extends SettingsAbstract {

    WebElement label;

    public ParentalControls() {
        checkPage();
    }

    private void checkPage() {
        try {
            label = new Element().elementByXpath("//android.view.View[@content-desc='My settings']");
        } catch (Exception e) {
            log.info("Need to login for the parental control page.");
            new SignIn().signIn(props.getPropertyValue("Username"), props.getPropertyValue("Password"));
            checkPage();
        }
    }
}
