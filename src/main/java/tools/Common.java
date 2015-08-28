package tools;

import org.openqa.selenium.WebElement;
import org.w3c.dom.NodeList;
import pageobjects.mainpages.Page;

/**
 * Created by cku04 on 18/08/2015.
 */
public class Common extends Page{


    public static void clickIfEnabledAndDisplayed(WebElement element){
        if(element.isEnabled() && element.isDisplayed())
            element.click();
    }

    public static void isElementDisplayed(WebElement... elements) {
        for (WebElement e : elements) {
            e.isDisplayed();
        }
    }

    public static void startRecordingClearCharlesSession() {
        Charles.startCharlesRecording();
        Charles.clearCharlesSession();

    }

    public static NodeList stopRecordingParseCharlesSession(String xpath) {
        Charles.stopCharlesRecording();
        return Charles.parseCharlesSession(xpath);
    }
}
