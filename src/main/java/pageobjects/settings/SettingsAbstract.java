package pageobjects.settings;

import pageobjects.mainpages.OnNowPage;
import pageobjects.mainpages.Page;
import tools.StackTraceInfo;

/**
 * Created by chandan on 8/24/2015.
 */
public class SettingsAbstract extends Page {

    public OnNowPage goBackToOnNow() {
        log.info(StackTraceInfo.getCurrentMethodName());
        pressBack();
        return new OnNowPage();
    }
}
