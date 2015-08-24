package pageobjects.settings.help;

import org.openqa.selenium.WebElement;
import pagecomponents.Element;
import pageobjects.settings.SettingsAbstract;

/**
 * Created by chandan on 8/24/2015.
 */
public class TermsConditions extends SettingsAbstract {

    WebElement termsConditions;

    public TermsConditions() {
        termsConditions = new Element().elementByXpath("//android.view.View[@content-desc='Sky Go/Sky Go Extra - Terms & Conditions']");
    }
}
