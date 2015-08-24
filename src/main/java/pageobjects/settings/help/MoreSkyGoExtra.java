package pageobjects.settings.help;

import org.openqa.selenium.WebElement;
import pagecomponents.Element;
import pageobjects.settings.SettingsAbstract;

/**
 * Created by chandan on 8/24/2015.
 */
public class MoreSkyGoExtra extends SettingsAbstract {

    WebElement aboutDownloads;

    public MoreSkyGoExtra() {
        aboutDownloads = new Element().elementByXpath("//android.view.View[@content-desc='More About Downloads']");
    }
}
