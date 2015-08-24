package pageobjects;

import pagecomponents.TextView;

/**
 * Created by cku04 on 20/08/2015.
 */
public class OnNowPage extends ShowCasePage {

    TextView allChannels, entertainment, sports;

    public OnNowPage() {
        allChannels = new TextView("All Channels");
        entertainment = new TextView("Entertainment");
        sports = new TextView("Sports");
    }

    public AllChannelsPage gotToAllChannels() {
        allChannels.click();
        return new AllChannelsPage();
    }


}
