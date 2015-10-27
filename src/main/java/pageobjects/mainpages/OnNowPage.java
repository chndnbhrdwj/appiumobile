package pageobjects.mainpages;

import pagecomponents.TextView;
import pageobjects.AllChannelsPage;
import pageobjects.ProgramDetailPage;

/**
 * Created by cku04 on 20/08/2015.
 */
public class OnNowPage extends ShowCasePage {

    TextView allChannels, entertainment, sports;

    public OnNowPage() {
        try {
            allChannels = new TextView("All Channels");
        } catch (Exception e) {
            goToOnNowPage();
        }
        entertainment = new TextView("Entertainment");
        sports = new TextView("Sports");
    }

    @Override
    public ProgramDetailPage clickShowcase() {
        clickShowcaseItem();
        return new ProgramDetailPage();
    }

    public AllChannelsPage gotToAllChannels() {
        allChannels.click();
        return new AllChannelsPage();
    }


}
