package pageobjects;

import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

/**
 * Created by chandan on 8/22/2015.
 */
public class ProgramDetailPage extends HomePage {

    @AndroidFindBy(id = "com.bskyb.skygo:id/programme_image")
    private WebElement programImage;

    @AndroidFindBy(id = "com.bskyb.skygo:id/button_watch")
    private WebElement buttonWatch;

    @AndroidFindBy(id = "com.bskyb.skygo:id/button_download")
    private WebElement buttonDownload;

    public Player watchProgram() {
        buttonWatch.click();
        return new Player();

    }

}
