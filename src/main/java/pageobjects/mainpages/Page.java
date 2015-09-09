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
import java.util.concurrent.TimeUnit;

/**
 * Created by cku04 on 17/08/2015.
 */
public class Page {
    public static AndroidDriver driver;
    public static Logger log;
    protected static SkygoProperties props;
    static WebDriverWait wait;
    protected boolean advertDisplayed;
    protected boolean videoDisplayed;

    public Page() {
        props = new SkygoProperties();
        log = Logger.getLogger(Page.class);
        driver = getInstance();
    }

    protected static WebElement waitForElement(WebElement element) {
        wait = new WebDriverWait(driver, 60000);
        WebElement e = wait.until(ExpectedConditions.visibilityOf(element));
        return e;
    }

    protected static WebElement waitForElementById(String id) {
        wait = new WebDriverWait(driver, 60000);
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.id(id)));
        return element;
    }

    protected static WebElement waitForElement(By by, int timeInSeconds) {
        wait = new WebDriverWait(driver, timeInSeconds);
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        return element;
    }

    protected static WebElement waitForElementByXpath(String xpath) {
        wait = new WebDriverWait(driver, 60000);
        WebElement element = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(xpath))));
        return element;
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
        //capabilities.setCapability("appWaitActivity", appPath);
        try {
            driver = new AndroidDriver<WebElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
            Charles.stopCharlesRecording();
            Common.startRecordingClearCharlesSession();
            log.info("Started charles recording.");
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
            try {
                WebElement splashPage = null;
                WebElement contextMenu = waitForElementById("com.bskyb.skygo:id/context_menu");
                if (!contextMenu.isDisplayed()) {
                    splashPage = waitForElement(By.id("com.bskyb.skygo:id/rich_pull_top_layout"), 3);
                }
                if (splashPage != null) {
                    new Button("Close").click();
                }
            } catch (Exception e) {

            }

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
