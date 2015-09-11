package pageobjects.mainpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pagecomponents.Element;
import tools.Common;

/**
 * Created by cku04 on 20/08/2015.
 */
public class SkyMoviesPage extends ShowCasePage {

    WebElement recentlyAdded;

    public SkyMoviesPage() {
        try {
            recentlyAdded = new Element().elementByXpath("//android.widget.TextView[@text='Recently Added']");
        } catch (Exception e) {
            goToSkyMoviesPage();
        }
        Common.swipeLeft(By.id("com.bskyb.skygo:id/image"));
    }

}
