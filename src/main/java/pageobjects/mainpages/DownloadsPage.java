package pageobjects.mainpages;

import pagecomponents.ImageView;

/**
 * Created by cku04 on 20/08/2015.
 */
public class DownloadsPage extends HomePage {
    ImageView emptyDownload;

    public DownloadsPage() {
        checkPage();
    }

    private void checkPage() {
        try {
            emptyDownload = new ImageView("com.bskyb.skygo:id/empty_dl");
            if (emptyDownload.isDisplayed())
                log.info("No downloads items found on Downloads page.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
