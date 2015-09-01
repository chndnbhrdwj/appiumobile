package test.skygo;

import org.junit.After;
import pageobjects.mainpages.Page;

/**
 * Created by cku04 on 20/08/2015.
 */
public class AbstractTest extends Page {


    @After
    public static void stopDriver() {
        stop();
    }

    public static void stop() {
        driver.quit();
    }

}
