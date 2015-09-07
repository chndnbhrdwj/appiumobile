package pageobjects.settings;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * Created by chandan on 8/24/2015.
 */
public class SkyAccount extends SettingsAbstract {

    WebElement goToGooglePlay;

    public SkyAccount() {
        goToGooglePlay = waitForElement(By.xpath("//android.view.View[@content-desc='Go to Google Play']"), 5);
    }

}
