package pageobjects.mainpages;

import org.openqa.selenium.WebElement;
import pagecomponents.Element;
import pagecomponents.ImageView;


/**
 * Created by chandan on 8/24/2015.
 */
public class ShowCasePage extends HomePage {
    ImageView showCaseItem;
    WebElement programName;

    public ShowCasePage() {
        showCaseItem = new ImageView("com.bskyb.skygo:id/image");
        programName = new Element().elementByResourceId("com.bskyb.skygo:id/program_title");
        //System.out.println("Program on screen is: " + programName.getAttribute("text"));
    }
}
