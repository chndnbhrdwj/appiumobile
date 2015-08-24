package pageobjects.settings.settingsmenu;

import org.openqa.selenium.WebElement;
import pagecomponents.Element;
import pageobjects.settings.SettingsAbstract;

/**
 * Created by chandan on 8/24/2015.
 */
public class NetworkPreferencesPage extends SettingsAbstract {

    WebElement allowStreaming;

    public NetworkPreferencesPage() {
        allowStreaming = new Element().elementByXpath("//android.widget.CheckBox[@text='Allow Streaming over 3G/4G']");
    }
}
