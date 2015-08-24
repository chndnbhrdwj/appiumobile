package pageobjects;

import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import pageobjects.mainpages.Page;

/**
 * Created by chandan on 8/22/2015.
 */
public class Player extends Page {

    @AndroidFindBy(id = "com.bskyb.skygo:id/video")
    private WebElement video;

    @AndroidFindBy(id = "com.bskyb.skygo:id/adCountdown")
    private WebElement adCountdown;

    @AndroidFindBy(id = "com.bskyb.skygo:id/adtext")
    private WebElement adText;

    @AndroidFindBy(id = "com.bskyb.skygo:id/videoview")
    private WebElement videoView;

    public void videoViewDisplayed() {
        try {
            adText.isDisplayed();
            adCountdown.isDisplayed();
            video.isDisplayed();
        } catch (NoSuchElementException e) {
            System.out.println("Advert was not displayed for this video stream");
        }
        videoView.isDisplayed();
    }
}
