package tools;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import pageobjects.Page;

/**
 * Created by cku04 on 18/08/2015.
 */
public class Common extends Page{

    public static void clickIfEnabledAndDisplayed(WebElement element){
        if(element.isEnabled() && element.isDisplayed())
            element.click();
    }


}
