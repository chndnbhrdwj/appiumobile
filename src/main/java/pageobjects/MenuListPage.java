package pageobjects;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by cku04 on 20/08/2015.
 */
public class MenuListPage extends Page{

    @AndroidFindBy(id="com.bskyb.skygo:id/menu_list")
    private WebElement menuList;

    @AndroidFindBy(xpath="//android.widget.TextView[@text='On Now']")
    private WebElement onNow;

    @AndroidFindBy(xpath="//android.widget.TextView[@text='Catch Up']")
    private WebElement catchUp;

    @AndroidFindBy(xpath="//android.widget.TextView[@text='Sky Box Sets']")
    private WebElement skyBoxSets;

    @AndroidFindBy(xpath="//android.widget.TextView[@text='Sky Movies']")
    private WebElement skyMovies;

    @AndroidFindBy(xpath="//android.widget.TextView[@text='Downloads']")
    private WebElement downloads;

    public OnNowPage goToOnNowPage(){
        onNow.click();
        return new OnNowPage();
    }
    public CatchUpPage goToCatchUpPage(){
        catchUp.click();
        return new CatchUpPage();
    }
    public SkyBoxSetsPage goToSkyBoxSetsPage(){
        skyBoxSets.click();
        return new SkyBoxSetsPage();
    }
    public SkyMoviesPage goToSkyMoviesPage(){
        skyMovies.click();
        return new SkyMoviesPage();
    }
    public DownloadsPage goToDownloadsPage(){
        downloads.click();
        return new DownloadsPage();
    }

}
