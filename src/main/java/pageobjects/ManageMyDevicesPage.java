package pageobjects;

import org.openqa.selenium.WebElement;
import pagecomponents.Element;

/**
 * Created by chandan on 8/24/2015.
 */
public class ManageMyDevicesPage extends Page {

    WebElement label;

    public ManageMyDevicesPage() {
        label = new Element().elementByXpath("//android.view.View[@content-desc='Manage your devices']");
    }

    public OnNowPage goBackToOnNow() {
        pressBack();
        return new OnNowPage();
    }
}
