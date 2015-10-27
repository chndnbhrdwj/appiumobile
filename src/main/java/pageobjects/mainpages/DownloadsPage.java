package pageobjects.mainpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * Created by cku04 on 20/08/2015.
 */
public class DownloadsPage extends HomePage {
    WebElement downloadsList, element;
    String emptyDownloadXpath = "//android.widget.ImageView[@resource-id='com.bskyb.skygo:id/empty_dl']";
    String downloadListXpath = "//android.widget.FrameLayout[@resource-id='com.bskyb.skygo:id/fragment_placeholder']//android.widget.ListView[@resource-id='com.bskyb.skygo:id/epglist']";
    String InProgressXpath = downloadListXpath + "//android.widget.TextView[@text='In Progress']";

    public DownloadsPage() {
        checkPage();
    }

    private void checkPage() {
        try {
            element = driver.findElement(By.xpath(downloadListXpath + " | " + emptyDownloadXpath));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private boolean downloadListPresent() {
        downloadsList = waitForElement(By.xpath(downloadListXpath), 1);
        return downloadsList.isDisplayed();
    }

    public DownloadsPage verifyDownloadProgress() {
        if (downloadListPresent()) {
            String itemXpath, textContainer, title, channel, percentage;
            itemXpath = InProgressXpath + "/following-sibling::android.widget.RelativeLayout[@resource-id='com.bskyb.skygo:id/downloads_list']";
            textContainer = "//android.widget.LinearLayout[@resource-id='com.bskyb.skygo:id/download_desc_section']";
            title = driver.findElement(By.xpath(itemXpath + textContainer + "/android.widget.TextView[@resource-id='com.bskyb.skygo:id/download_title']")).getText();
            channel = driver.findElement(By.xpath(itemXpath + textContainer + "//android.widget.TextView[@resource-id='com.bskyb.skygo:id/broadcast_channel']")).getText();
            percentage = driver.findElement(By.xpath(itemXpath + "//android.widget.TextView[@resource-id='com.bskyb.skygo:id/download_details']")).getText();
            log.info("Title is " + title + " Channel is " + channel + " Percentage is " + percentage);
        }
        return this;
    }
}
