package pageobjects.settings.settingsmenu;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pageobjects.settings.SettingsAbstract;

/**
 * Created by chandan on 8/24/2015.
 */
public class ManageMyDevicesPage extends SettingsAbstract {

    WebElement label;

    public ManageMyDevicesPage() {
        try {
            label = waitForElement(By.xpath("//android.view.View[@content-desc='Manage your devices']"), 3);
        } catch (Exception e) {
            log.info("Probably user has not login recently.");
        }
    }

}
