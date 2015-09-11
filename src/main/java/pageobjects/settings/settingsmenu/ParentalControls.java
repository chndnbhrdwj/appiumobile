package pageobjects.settings.settingsmenu;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
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
            label = waitForElement(By.xpath("//android.view.View[@content-desc='My settings']"), 3);
        } catch (Exception e) {
            log.info("Probably user has not login recently.");
        }
    }
}
