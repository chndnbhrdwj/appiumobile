package pageobjects.mainpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pagecomponents.Element;
import test.skygo.SkyGoApp;

/**
 * Created by cku04 on 11/09/2015.
 */
public class SearchPage extends HomePage {

    WebElement searchBox, searchList;
    private String searchListXpath = "//android.widget.ExpandableListView/android.widget.LinearLayout/android.widget.ImageView/following-sibling::android.widget.LinearLayout";

    public SearchPage() {
        searchBox = new Element().elementByXpath("//android.widget.EditText[@resource-id='com.bskyb.skygo:id/searchtxt'][contains(@text,'Search by title, actor, event')]");
    }

    public SearchPage searchText(String text) {
        searchBox.sendKeys(text);
        new SkyGoApp().sendAdbEnterKey();
        searchList = waitForElement(By.id("com.bskyb.skygo:id/searchlist"), 3);
        int size = getListElements(By.xpath(searchListXpath)).size();
        if (size > 0) {
            log.info("Search for text " + text + " returned " + size + " items.");
        }
        return this;
    }
}
