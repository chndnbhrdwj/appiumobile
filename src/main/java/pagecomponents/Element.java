package pagecomponents;

import org.openqa.selenium.WebElement;
import pageobjects.mainpages.Page;

/**
 * Created by chandan on 8/24/2015.
 */
public class Element extends Page {

    public WebElement elementByXpath(String xpath) {
        return driver.findElementByXPath(xpath);
    }

    public WebElement elementByResourceId(String resourceId) {
        return driver.findElementById(resourceId);
    }

    public WebElement elementByName(String name) {
        return driver.findElementByName(name);
    }
}
