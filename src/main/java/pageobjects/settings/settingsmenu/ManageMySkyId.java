package pageobjects.settings.settingsmenu;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pageobjects.settings.SettingsAbstract;

/**
 * Created by chandan on 8/24/2015.
 */
public class ManageMySkyId extends SettingsAbstract {

    WebElement myDetails;

    public ManageMySkyId() {
        try {
            myDetails = waitForElement(By.xpath("//android.view.View[@content-desc='My details']"), 10);
        } catch (Exception e) {
            log.info("Probably user has not login recently.");
        }
    }
}
