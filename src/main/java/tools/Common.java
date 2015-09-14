package tools;

import io.appium.java_client.MobileElement;
import io.appium.java_client.NetworkConnectionSetting;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebElement;
import org.w3c.dom.NodeList;
import pageobjects.mainpages.Page;

import java.util.HashMap;

/**
 * Created by cku04 on 18/08/2015.
 */
public class Common extends Page{


    public static void startRecordingClearCharlesSession() {
        Charles.startCharlesRecording();
        Charles.clearCharlesSession();

    }

    public static NodeList stopRecordingParseCharlesSession(String xpath) {
        Charles.stopCharlesRecording();
        return Charles.parseCharlesSession(xpath);
    }

    public static void swipeLeft(By by) {
        MobileElement element = (MobileElement) driver.findElement(by);
        int offset = 1;
        Point p = element.getCenter();
        Point location = element.getLocation();
        Dimension size = element.getSize();
        driver.swipe(location.getX() + size.getWidth() - offset, p.getY(),
                location.getX() + offset, p.getY(), 1000);
    }

    public static void swipeRight(By by) {
        MobileElement element = (MobileElement) driver
                .findElement(by);
        int offset = 1;
        Point p = element.getCenter();
        Point location = element.getLocation();
        Dimension size = element.getSize();
        driver.swipe(location.getX() + offset + 20, p.getY(),
                location.getX() + size.getWidth() - offset, p.getY(), 1000);
    }

    public static void scrollDown(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        HashMap<String, String> scrollObject = new HashMap<String, String>();
        scrollObject.put("direction", "down");
        scrollObject.put("element", ((RemoteWebElement) element).getId());
        js.executeScript("mobile: scroll", scrollObject);
    }

    public static void doubleClick(WebElement element) {
        Actions action = new Actions(driver);
        action.doubleClick(element);
        action.perform();
    }

    public static void setNetworkOff() {
        NetworkConnectionSetting conn = new NetworkConnectionSetting(true, false, false);
        driver.setNetworkConnection(conn);
        log.info("Network set to Aeroplane mode");
    }

    public static void setNetworkWifi() {
        NetworkConnectionSetting conn = new NetworkConnectionSetting(false, true, false);
        driver.setNetworkConnection(conn);
        log.info("Network set to Wifi");
    }

    public static void setNetworkData() {
        NetworkConnectionSetting conn = new NetworkConnectionSetting(false, false, true);
        driver.setNetworkConnection(conn);
        log.info("Network set to Mobile Data");
    }

    public static void openNotifications() {
        driver.openNotifications();
    }

    public static void scrollToText(String text) {
        driver.findElementByAndroidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true).instance(0))" +
                        ".scrollIntoView(new UiSelector()" +
                        ".textContains(\"" + text + "\").instance(0))")
                .click();
    }
}
