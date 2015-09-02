package pageobjects;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import pagecomponents.Element;
import pageobjects.mainpages.Page;
import tools.StackTraceInfo;

/**
 * Created by chandan on 8/22/2015.
 */
public class Player extends Page {

    WebElement adCountdown, adText, advertVideo, videoView;

    public Player() {
        videoView = new Element().elementByResourceId("com.bskyb.skygo:id/videoview");
    }

    public Player videoViewDisplayed() {
        log.info(StackTraceInfo.getCurrentMethodName());
        try {
            adCountdown = new Element().elementByResourceId("com.bskyb.skygo:id/adCountdown");
            adText = new Element().elementByResourceId("com.bskyb.skygo:id/adtext");
            adText.isDisplayed();
            adCountdown.isDisplayed();
            log.info("Advert was displayed for selected video stream");
            waitForElement(videoView);
            videoView.isDisplayed();
        } catch (NoSuchElementException e) {
            log.info("Advert was not displayed for this video stream");
            videoView.isDisplayed();
        }
        return this;
    }

    public ProgramDetailPage backToProgramDetails() {
        log.info(StackTraceInfo.getCurrentMethodName());
        pressBack();
        return new ProgramDetailPage();
    }
}
