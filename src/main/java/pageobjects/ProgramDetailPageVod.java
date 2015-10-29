package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pagecomponents.Button;
import pagecomponents.TextView;
import pageobjects.mainpages.DownloadsPage;
import pageobjects.mainpages.SkyMoviesPage;
import pojo.DownloadItem;
import tools.Common;

/**
 * Created by chandan on 8/22/2015.
 */
public class ProgramDetailPageVod extends ProgramDetailPage {

    WebElement buttonDownload, buttonQueued, buttonDownloading, downloadNotification;
    TextView youCanDownloadTextView;
    String downloadNotificationXpath = "//android.widget.FrameLayout/android.widget.FrameLayout/android.widget.RelativeLayout";
    DownloadsPage downloadsPage;
    DownloadItem downloadItem;

    public DownloadsPage downloadProgram() {
        if (downloadButtonPresent()) {
            buttonDownload.click();
            if (skyGoExtraPresent()) {
                new Button("Continue").click();
            }
            if(buttonDownloadingPresent()){
                downloadsPage = verifyDownload();
            }else{
                launchNextProgram();
                downloadProgram();
            }
        } else {
            launchNextProgram();
            downloadProgram();
        }
        return downloadsPage;
    }

    private boolean downloadButtonPresent() {
        buttonDownload = waitForElement(By.xpath("//android.widget.Button[@text='Download']"), 2);
        return (buttonDownload != null) ? true : false;
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
        buttonQueued = waitForElement(By.xpath("//android.widget.Button[@text='Queued']"), 5);
        return (buttonQueued != null) ? buttonQueued.isDisplayed() : false;
    }

    private boolean buttonDownloadingPresent() {
        buttonDownloading = waitForElement(By.xpath("//android.widget.Button[@text='Downloading']"), 30);
        return (buttonDownloading != null) ? buttonDownloading.isDisplayed() : false;
    }

    public DownloadsPage verifyDownload() {
        Common.openNotifications();
        downloadNotification = waitForElement(By.xpath(downloadNotificationXpath + "/android.widget.ProgressBar[@resource-id='com.bskyb.skygo:id/notificationProgressBar']"), 20);
        return openDownload();
    }

    private DownloadsPage openDownload() {
        String downloadTitle = waitForElement(By.xpath(downloadNotificationXpath + "/android.widget.TextView[@resource-id='com.bskyb.skygo:id/text']"), 1).getAttribute("text");
        String downloadPercentage = waitForElement(By.xpath(downloadNotificationXpath + "/android.widget.TextView[@resource-id='com.bskyb.skygo:id/progress_text']"), 1).getAttribute("text");
        downloadItem = new DownloadItem();
        downloadItem.setPercentage(downloadPercentage);
        downloadItem.setTitle(downloadTitle);
        log.info("Download notification for " + downloadTitle + " with progress " + downloadPercentage);
        downloadNotification.click();
        return new DownloadsPage();
    }

    private ProgramDetailPage launchNextProgram() {
        pressBack();
        return new SkyMoviesPage()
                .swipeLeft()
                .clickShowcase();
    }
}
