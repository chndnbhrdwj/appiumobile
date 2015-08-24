package skygo;

import org.junit.AfterClass;
import pageobjects.mainpages.Page;

/**
 * Created by cku04 on 20/08/2015.
 */
public class AbstractTest extends Page{


    @AfterClass
    public static void stopDriver() {
        stop();
    }

    public static void stop() {
        driver.quit();
    }
}
