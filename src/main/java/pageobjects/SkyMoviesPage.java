package pageobjects;

import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

/**
 * Created by cku04 on 20/08/2015.
 */
public class SkyMoviesPage extends HomePage{

    @AndroidFindBy(id = "com.bskyb.skygo:id/image")
    private WebElement showcaseItem;

    @AndroidFindBy(id = "com.bskyb.skygo:id/program_title")
    private WebElement programName;

    @AndroidFindBy(id = "com.bskyb.skygo:id/channel_name")
    private WebElement channelName;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Recently Added']")
    private WebElement recentlyAdded;

    public ProgramDetailPage clickShowcaseItem() {
        System.out.println("Playing program: " + channelName.getAttribute("text") + ": " + programName.getAttribute("text"));
        showcaseItem.click();
        return new ProgramDetailPage();
    }

}
