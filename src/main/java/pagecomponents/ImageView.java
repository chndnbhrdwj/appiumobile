package pagecomponents;

import org.openqa.selenium.WebElement;
import pageobjects.Page;

/**
 * Created by chandan on 8/24/2015.
 */
public class ImageView extends Page {

    WebElement image;

    public ImageView(String id) {
        image = driver.findElementById(id);
    }

    public void click() {
        image.click();
    }
}
