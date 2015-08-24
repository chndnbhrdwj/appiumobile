package pageobjects.settings.help;

import pagecomponents.TextView;
import pageobjects.settings.SettingsAbstract;

/**
 * Created by chandan on 8/24/2015.
 */
public class SkyUKApps extends SettingsAbstract {

    TextView skyApps;

    public SkyUKApps() {
        skyApps = new TextView("pub:\"BSkyB\"");
    }
}
