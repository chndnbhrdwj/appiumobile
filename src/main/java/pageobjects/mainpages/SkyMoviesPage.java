package pageobjects.mainpages;

import org.openqa.selenium.WebElement;
import pagecomponents.Element;
import pageobjects.ProgramDetailPage;

/**
 * Created by cku04 on 20/08/2015.
 */
public class SkyMoviesPage extends ShowCasePage {

    WebElement recentlyAdded;

    public SkyMoviesPage() {
        recentlyAdded = new Element().elementByXpath("//android.widget.TextView[@text='Recently Added']");
    }

    public ProgramDetailPage clickShowcaseItem() {
        showCaseItem.click();
        return new ProgramDetailPage();
    }

}
