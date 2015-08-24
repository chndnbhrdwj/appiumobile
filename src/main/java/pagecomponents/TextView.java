package pagecomponents;

import org.openqa.selenium.WebElement;
import pageobjects.Page;

/**
 * Created by chandan on 8/24/2015.
 */
public class TextView extends Page {

    WebElement element;

    public TextView(String text) {
        element = driver.findElementByXPath("//android.widget.TextView[@text='" + text + "']");
    }

    public void click() {
        element.click();
    }
}
