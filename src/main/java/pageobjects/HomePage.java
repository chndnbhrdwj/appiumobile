package pageobjects;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import tools.Common;

/**
 * Created by cku04 on 17/08/2015.
 */
public class HomePage extends Page{

    @AndroidFindBy(id="com.bskyb.skygo:id/more")
    private WebElement settings;

    @AndroidFindBy(id="com.bskyb.skygo:id/search")
    private WebElement search;

    @AndroidFindBy(id="com.bskyb.skygo:id/context_menu")
    private WebElement contextMenu;

    public MenuListPage gotToMenuListPage()throws Exception{
        contextMenu.click();
        return new MenuListPage();
    }
}
