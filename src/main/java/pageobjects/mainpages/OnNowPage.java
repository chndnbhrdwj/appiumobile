package pageobjects.mainpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pagecomponents.TextView;
import pageobjects.AllChannelsPage;
import pageobjects.ProgramDetailPage;

/**
 * Created by cku04 on 20/08/2015.
 */
public class OnNowPage extends ShowCasePage {

    WebElement allChannels;
    TextView entertainment, sports;

    public OnNowPage() {
        try {
            allChannels = waitForElement(By.xpath("//android.widget.TextView[@text='On Now']"), 1);
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
