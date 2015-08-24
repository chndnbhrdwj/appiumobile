package pageobjects.settings;

import org.openqa.selenium.WebElement;
import pagecomponents.Element;

/**
 * Created by chandan on 8/24/2015.
 */
public class SelectConfig extends SettingsAbstract {

    WebElement prod, t2;

    public SelectConfig() {
        prod = new Element().elementByXpath("//android.widget.RadioButton[@text='Prod']");
        t2 = new Element().elementByXpath("//android.widget.RadioButton[@text='T2']");
    }

}
