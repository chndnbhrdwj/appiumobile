package pageobjects.mainpages;

import core.SkygoProperties;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import test.skygo.Applifecycle;
import tools.Charles;
import tools.Common;

import java.net.URL;
import java.util.concurrent.TimeUnit;

/**
 * Created by cku04 on 17/08/2015.
 */
public class Page {
    public static AppiumDriver<?> driver;
    public static Logger log;
    protected static SkygoProperties props;
    protected boolean signedIn;


    public Page() {
        props = new SkygoProperties();
        log = Logger.getLogger(Page.class);
        driver = getInstance();
    }

    protected static WebElement waitForElement(WebElement element) {
        new WebDriverWait(driver, 120000).until(ExpectedConditions.visibilityOf(element));
        return element;
    }

    protected static WebElement waitForElementById(String id) {
        WebElement element = new WebDriverWait(driver, 120000).until(ExpectedConditions.visibilityOf(driver.findElementById(id)));
        return element;
    }

    protected static WebElement waitForElementByXpath(String xpath) {
        WebElement element = new WebDriverWait(driver, 120000).until(ExpectedConditions.visibilityOf(driver.findElementByXPath(xpath)));
        return element;
    }

    private static AppiumDriver getInstance() {
        if (driver != null) {
            return driver;
        }
        try {
            Applifecycle app = new Applifecycle();
            log.info("Downloading app from Jenkins.");
            app.download();
            log.info("Uninstalling the app from device.");
            app.uninstall();
            log.info("Installing the app on device.");
            app.install();
        } catch (Exception e) {
            log.info("Error occurred ..");
            e.printStackTrace();
        }
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName", "Nexus 6");
        capabilities.setCapability("platformVersion", "5.1.1");
        capabilities.setCapability("appPackage", "com.bskyb.skygo");
        capabilities.setCapability("appActivity", "component.fragment.main.SkyGoActivity");
        //capabilities.setCapability("fullReset", "true");
        //capabilities.setCapability("app", "/Users/cku04/appiumobile/SkyGo.apk");
        //capabilities.setCapability("appWaitActivity", appPath);
        try {
            driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
            Charles.stopCharlesRecording();
            Common.startRecordingClearCharlesSession();
            log.info("Started charles recording.");
            driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);
            waitForElementById("com.bskyb.skygo:id/context_menu");
        } catch (Exception e) {
            log.info("The driver was not initialized successfully or Homepage took more than 90 secs to load.");
            System.exit(1);
        }
        return driver;
    }

    public void pressBack() {
        driver.navigate().back();
    }
}
