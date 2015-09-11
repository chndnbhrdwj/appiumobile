package pageobjects.mainpages;

import org.openqa.selenium.WebElement;
import pagecomponents.Element;
import pageobjects.ProgramDetailPage;

/**
 * Created by cku04 on 17/08/2015.
 */
public class CatchUpPage extends ShowCasePage {

    WebElement genres, featured, skyChannels;

    public CatchUpPage() {
        try {
            genres = new Element().elementByResourceId("com.bskyb.skygo:id/genres");
            featured = new Element().elementByXpath("//android.widget.TextView[@text='Featured']");
            skyChannels = new Element().elementByXpath("//android.widget.TextView[@text='Sky Channels']");
        } catch (Exception e) {
            goToCatchUpPage();
        }
    }

    @Override
    public ProgramDetailPage clickShowcase() {
        return null;
    }

}
