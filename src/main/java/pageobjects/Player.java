package pageobjects;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import pagecomponents.Element;
import pageobjects.mainpages.Page;

/**
 * Created by chandan on 8/22/2015.
 */
public class Player extends Page {

    WebElement adCountdown, adText, videoView;

    public Player() {
        videoView = new Element().elementByResourceId("com.bskyb.skygo:id/videoview");
    }

    public Player videoViewDisplayed() {
        try {
            adCountdown = new Element().elementByResourceId("com.bskyb.skygo:id/adCountdown");
            adText = new Element().elementByResourceId("com.bskyb.skygo:id/adtext");
            adText.isDisplayed();
            adCountdown.isDisplayed();
        } catch (NoSuchElementException e) {
            System.out.println("Advert was not displayed for this video stream");
        }
        videoView.isDisplayed();
        return this;
    }

    public ProgramDetailPage backToProgramDetails() {
        pressBack();
        return new ProgramDetailPage();
    }
}
