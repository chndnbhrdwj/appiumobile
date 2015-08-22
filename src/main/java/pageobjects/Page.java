package pageobjects;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;

import java.net.URL;
import java.util.concurrent.TimeUnit;

/**
 * Created by cku04 on 17/08/2015.
 */
public class Page{
    public static AndroidDriver driver;

    public Page(){
        PageFactory.initElements(new AppiumFieldDecorator(getInstance()),this);
    }

    private static AndroidDriver getInstance(){
        if(driver != null){
            return driver;
        }
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName","Nexus 6");
        capabilities.setCapability("platformVersion", "5.1.1");
        capabilities.setCapability("appPackage", "com.bskyb.skygo");
        capabilities.setCapability("appActivity", "component.fragment.main.SkyGoActivity");
        try{
            driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
            driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);
            Thread.sleep(3000);
        }catch (Exception e){
            e.getMessage();
        }
        return driver;
    }
}
