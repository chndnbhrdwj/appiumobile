package pageobjects.settings.help;

import pagecomponents.TextView;
import pageobjects.settings.SettingsAbstract;

/**
 * Created by chandan on 8/24/2015.
 */
public class About extends SettingsAbstract {

    TextView version;

    public About() {
        version = new TextView("About SkyGo");
    }
}
