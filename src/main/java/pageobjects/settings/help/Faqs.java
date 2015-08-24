package pageobjects.settings.help;

import org.openqa.selenium.WebElement;
import pagecomponents.Element;
import pageobjects.settings.SettingsAbstract;

/**
 * Created by chandan on 8/24/2015.
 */
public class Faqs extends SettingsAbstract {

    WebElement whatIsSkyGo;

    public Faqs() {
        whatIsSkyGo = new Element().elementByXpath("//android.view.View[@content-desc='1) What is Sky Go?']");
    }
}
