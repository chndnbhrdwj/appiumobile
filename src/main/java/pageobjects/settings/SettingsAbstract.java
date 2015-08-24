package pageobjects.settings;

import pageobjects.mainpages.OnNowPage;
import pageobjects.mainpages.Page;

/**
 * Created by chandan on 8/24/2015.
 */
public class SettingsAbstract extends Page {

    public OnNowPage goBackToOnNow() {
        pressBack();
        return new OnNowPage();
    }
}
