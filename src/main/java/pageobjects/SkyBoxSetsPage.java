package pageobjects;

import org.openqa.selenium.WebElement;
import pagecomponents.Element;

/**
 * Created by cku04 on 20/08/2015.
 */
public class SkyBoxSetsPage extends ShowCasePage {

    WebElement slideView;

    public SkyBoxSetsPage() {
        slideView = new Element().elementByResourceId("com.bskyb.skygo:id/now_featured_slide_listview");
    }



}
