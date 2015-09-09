package tools;

import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.w3c.dom.NodeList;
import pageobjects.mainpages.Page;

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
}
