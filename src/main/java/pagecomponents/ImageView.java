package pagecomponents;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pageobjects.mainpages.Page;

/**
 * Created by chandan on 8/24/2015.
 */
public class ImageView extends Page {

    WebElement image;

    public ImageView(String id) {
        image = waitForElement(By.id(id), 3);
    }

    public void click() {
        image.click();
    }

    public boolean isDisplayed() {
        return image.isDisplayed();
    }
}
