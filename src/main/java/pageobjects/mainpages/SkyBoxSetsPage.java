package pageobjects.mainpages;

import org.openqa.selenium.WebElement;
import pagecomponents.Element;
import pageobjects.ProgramDetailPage;

/**
 * Created by cku04 on 20/08/2015.
 */
public class SkyBoxSetsPage extends ShowCasePage {

    WebElement slideView;

    public SkyBoxSetsPage() {
        try {
            slideView = new Element().elementByResourceId("com.bskyb.skygo:id/now_featured_slide_listview");
        } catch (Exception e) {
            goToSkyBoxSetsPage();
        }
    }

    @Override
    public ProgramDetailPage clickShowcase() {
        return null;
    }


}
