package pageobjects;

import org.openqa.selenium.WebElement;
import pagecomponents.Element;
import pageobjects.mainpages.Page;

/**
 * Created by chandan on 8/22/2015.
 */
public class Player extends Page {

    WebElement adCountdown, adText, videoView;

    public Player() {

    }

    public Player videoViewDisplayed() {
        log.info("");
        try {
            adCountdown = new Element().elementByResourceId("com.bskyb.skygo:id/adCountdown");
            adText = new Element().elementByResourceId("com.bskyb.skygo:id/adtext");
            log.info("Advert was displayed for selected video stream");
            if (adCountdown.isDisplayed()) {
                Thread.sleep(40000);
            }
        } catch (Exception e) {
            log.info("Advert was not displayed for this video stream");
            e.printStackTrace();
        }
        isVideoViewPresent();
        return this;
    }

    public ProgramDetailPage backToProgramDetails() {
        log.info("");
        pressBack();
        return new ProgramDetailPage();
    }

    public boolean isVideoViewPresent() {
        videoView = waitForElementByXpath("//android.widget.FrameLayout[@resource-id='com.bskyb.skygo:id/videoview']");
        return videoView.isDisplayed();
    }
}
