package pageobjects.settings.settingsmenu;

import org.openqa.selenium.WebElement;
import pagecomponents.Element;
import pageobjects.settings.SettingsAbstract;

/**
 * Created by chandan on 8/24/2015.
 */
public class ManageMySkyId extends SettingsAbstract {

    WebElement myDetails;

    public ManageMySkyId() {
        myDetails = new Element().elementByXpath("//android.view.View[@content-desc='My details']");
    }
}
