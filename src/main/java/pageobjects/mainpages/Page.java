package pageobjects.mainpages;

import core.SkygoProperties;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import tools.Charles;
import tools.Common;

import java.net.URL;
import java.util.concurrent.TimeUnit;

/**
 * Created by cku04 on 17/08/2015.
 */
public class Page {
    public static AppiumDriver driver;
    public static Logger log;
    protected static SkygoProperties props;


    public Page() {
        props = new SkygoProperties();
        log = Logger.getLogger(Page.class);
        driver = getInstance();
    }

    protected static WebElement waitForElement(WebElement element) {
        new WebDriverWait(driver, 60000).until(ExpectedConditions.visibilityOf(element));
        return element;
    }

    private static AppiumDriver getInstance() {
        if (driver != null) {
            return driver;
        }
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName", "Nexus 6");
        capabilities.setCapability("platformVersion", "5.1.1");
        capabilities.setCapability("appPackage", "com.bskyb.skygo");
        capabilities.setCapability("appActivity", "component.fragment.main.SkyGoActivity");
        try {
            driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
            Charles.stopCharlesRecording();
            Common.startRecordingClearCharlesSession();
            log.info("Started charles recording.");
            driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
            waitForElement(driver.findElement(By.id("com.bskyb.skygo:id/context_menu")));
        } catch (Exception e) {
            log.info("The driver was not initialized successfully or Homepage took more than 60 secs to load.");
            System.exit(1);
        }
        return driver;
    }

    public void pressBack() {
        driver.navigate().back();
    }
}
