package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pagecomponents.Button;
import pagecomponents.TextView;
import pageobjects.mainpages.DownloadsPage;
import tools.Common;

/**
 * Created by chandan on 8/22/2015.
 */
public class ProgramDetailPageVod extends ProgramDetailPage {

    WebElement buttonDownload, buttonQueued, buttonDownloading;
    TextView youCanDownloadTextView;

    public ProgramDetailPageVod downloadProgram() {
        if (downloadButtonPresent()) {
            buttonDownload.click();
            if (skyGoExtraPresent()) {
                new Button("Continue").click();
            }
            buttonQueued();
            buttonDownloading();
        } else {
            pressBack();
            Common.swipeLeft(By.id("com.bskyb.skygo:id/image"));
            downloadProgram();
        }
        return this;
    }

    private boolean downloadButtonPresent() {
        try {
            buttonDownload = waitForElement(By.xpath("//android.widget.Button[@text='Download']"), 2);
        } catch (Exception e) {
            log.info("Download button not available for this program.");
            return false;
        }
        return true;
    }

    private boolean skyGoExtraPresent() {
        try {
            youCanDownloadTextView = new TextView("Now you can download popular movies and shows to this device");
        } catch (Exception e) {
            log.info("Sky Go Extra dialog was not displayed");
            return false;
        }
        return youCanDownloadTextView.isDisplayed();
    }

    private boolean buttonQueued() {
        try {
            buttonQueued = waitForElement(By.xpath("//android.widget.Button[@text='Queued']"), 5);
        } catch (Exception e) {
            log.info("Button Queued was not displayed");
            return false;
        }
        return buttonQueued.isDisplayed();
    }

    private boolean buttonDownloading() {
        try {
            buttonDownloading = waitForElement(By.xpath("//android.widget.Button[@text='Downloading']"), 10);
        } catch (Exception e) {
            log.info("Button Downloading was not displayed");
            return false;
        }
        return buttonDownloading.isDisplayed();
    }

    public DownloadsPage verifyDownload() {

        return new DownloadsPage();
    }
}
