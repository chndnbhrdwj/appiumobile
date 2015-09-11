package pageobjects.mainpages;

import core.SkygoProperties;
import io.appium.java_client.android.AndroidDriver;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pagecomponents.Button;
import test.skygo.SkyGoApp;
import tools.Charles;
import tools.Common;

import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by cku04 on 17/08/2015.
 */
public class Page {
    public static AndroidDriver driver;
    public static Logger log;
    protected static SkygoProperties props;
    protected boolean advertDisplayed;
    protected boolean videoDisplayed;

    public Page() {
        props = new SkygoProperties();
        log = Logger.getLogger(Page.class);
        driver = getInstance();
    }

    protected static WebElement waitForElement(By by, int timeInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, timeInSeconds);
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        return element;
    }

    protected static List<WebElement> getListElements(By by) {
        List<WebElement> list = driver.findElements(by);
        return list;
    }

    protected static boolean waitForElementToDisappear(By by, int timeInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, timeInSeconds);
        boolean disappeared = wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
        return disappeared;
    }

    private static AndroidDriver getInstance() {
        if (driver != null) {
            return driver;
        }
        if (props.getPropertyValue("RunOnJenkins").equals("true")) {
        try {
            SkyGoApp app = new SkyGoApp();
            log.info("Downloading app from Jenkins.");
            app.download();
            log.info("Uninstalling the app from device.");
            app.uninstall();
            log.info("Installing the app on device.");
            app.install();
            log.info("Clearing the app data from device.");
            app.clear();
            log.info("Setting the Charles proxy config on device.");
            app.installProxyApp();
            app.setProxy();
        } catch (Exception e) {
            log.info("Error occurred ..");
            e.printStackTrace();
        }
        }
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName", "Nexus 6");
        capabilities.setCapability("platformVersion", "5.1.1");
        capabilities.setCapability("appPackage", "com.bskyb.skygo");
        capabilities.setCapability("appActivity", "component.fragment.main.SkyGoActivity");
        capabilities.setCapability("newCommandTimeout", "120");
        //capabilities.setCapability("fullReset", "true");
        //capabilities.setCapability("app", "/Users/cku04/appiumobile/SkyGo.apk");
        //capabilities.setCapability("appWaitActivity", "component.fragment.main.HomeFragment");

        try {
            driver = new AndroidDriver<WebElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
            Charles.stopCharlesRecording();
            Common.startRecordingClearCharlesSession();
            log.info("Started charles recording.");
            driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

            boolean animationDisappeared = waitForElementToDisappear(By.id("com.bskyb.skygo:id/animation_placeholder"), 60);
            if (animationDisappeared) {
                try {
                    waitForElement(By.id("com.bskyb.skygo:id/context_menu"), 2);
                } catch (Exception e) {
                    closeSplashScreen();
                }
            }
        } catch (Exception e) {
            log.info("The driver was not initialized successfully or Homepage took more than 60 secs to load.");
            System.exit(1);
        }
        return driver;
    }

    private static void closeSplashScreen() {
        try {
            WebElement splashPage = waitForElement(By.id("com.bskyb.skygo:id/rich_pull_top_layout"), 1);
            if (splashPage.isDisplayed()) {
                new Button("Close").click();
            }
        } catch (Exception e) {
            log.info("Splash page was not displayed");
        }
    }

    public void pressBack() {
        driver.navigate().back();
    }
}
