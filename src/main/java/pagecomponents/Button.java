package pagecomponents;

import org.openqa.selenium.WebElement;
import pageobjects.mainpages.Page;

/**
 * Created by chandan on 8/24/2015.
 */
public class Button extends Page {

    WebElement element;

    public Button(String text) {
        element = driver.findElementByXPath("//android.widget.Button[@text='" + text + "']");
    }

    public void click() {
        element.click();
    }
}
