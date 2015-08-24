package pageobjects.mainpages;

import org.openqa.selenium.WebElement;
import pagecomponents.Element;

/**
 * Created by cku04 on 17/08/2015.
 */
public class CatchUpPage extends ShowCasePage {

    WebElement genres, featured, skyChannels;

    public CatchUpPage() {
        genres = new Element().elementByResourceId("com.bskyb.skygo:id/genres");
        featured = new Element().elementByXpath("//android.widget.TextView[@text='Featured']");
        skyChannels = new Element().elementByXpath("//android.widget.TextView[@text='Sky Channels']");
    }

}
