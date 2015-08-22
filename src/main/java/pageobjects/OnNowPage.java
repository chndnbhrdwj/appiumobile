package pageobjects;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by cku04 on 20/08/2015.
 */
public class OnNowPage extends HomePage {

    @AndroidFindBy(xpath="//android.widget.ImageView[@resource-id='com.bskyb.skygo:id/image'][@enabled='true']")
    private WebElement showCaseItem;

    @AndroidFindBy(xpath="//android.widget.TextView[@text='All Channels']")
    private WebElement allChannels;

    @AndroidFindBy(xpath="//android.widget.TextView[@text='Entertainment']")
    private WebElement entertainment;

    @AndroidFindBy(xpath="//android.widget.TextView[@text='Movies']")
    private WebElement movies;

    @AndroidFindBy(xpath="//android.widget.TextView[@text='Sports']")
    private WebElement sports;


    public AllChannelsPage gotToAllChannels(){
        allChannels.click();
        return new AllChannelsPage();
    }


}
