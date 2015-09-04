package pageobjects.settings;

import org.openqa.selenium.WebElement;
import pagecomponents.Element;

/**
 * Created by chandan on 8/24/2015.
 */
public class SkyAccount extends SettingsAbstract {

    WebElement goToGooglePlay;

    public SkyAccount() {
        goToGooglePlay = new Element().elementByXpath("//android.view.View[@content-desc='Go to Google Play']");
        goToGooglePlay.isDisplayed();
    }

}
