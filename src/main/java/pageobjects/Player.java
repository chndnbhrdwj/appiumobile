package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pagecomponents.Button;
import pagecomponents.Element;
import pageobjects.mainpages.Page;

/**
 * Created by chandan on 8/22/2015.
 */
public class Player extends Page {

    WebElement adCountdown, adText, videoView;

    public Player videoViewDisplayed() {
        try {
            adCountdown = waitForElement(By.id("com.bskyb.skygo:id/adCountdown"), 8);
            adText = new Element().elementByResourceId("com.bskyb.skygo:id/adtext");
            log.info("Advert was displayed for selected video stream, Waiting for the content to show up.");
            advertDisplayed = true;
        } catch (Exception e) {
            try {
                Button btnWatch = new Button("Watch");
                if (btnWatch.isDisplayed()) {
                    btnWatch.click();
                    log.info("Clicked the Watch button again.");
                }
            } catch (Exception exception) {
                log.info("Advert was not displayed for this video stream");
            }
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
        videoView = waitForElement(By.id("com.bskyb.skygo:id/videoview"), 120);
        videoDisplayed = true;
        return videoView.isDisplayed();
    }
}
