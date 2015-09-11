package pageobjects.mainpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pagecomponents.ImageView;
import pageobjects.ProgramDetailPage;


/**
 * Created by chandan on 8/24/2015.
 */
public class ShowCasePage extends HomePage {
    ImageView showCaseItem;
    WebElement programName;

    public ShowCasePage() {
        try {
            showCaseItem = new ImageView("com.bskyb.skygo:id/image");
        } catch (Exception e) {
            log.info("Showcase page was not found as expected: " + e.getMessage());
        }
    }

    public ProgramDetailPage clickShowcaseItem() {
        programName = waitForElement(By.id("com.bskyb.skygo:id/program_title"), 5);
        log.info("Loading Program details page for showcase item named: " + programName.getAttribute("text"));
        showCaseItem.click();
        return new ProgramDetailPage();
    }
}
