package skygo;

import io.appium.java_client.AppiumDriver;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import pageobjects.Page;

/**
 * Created by cku04 on 20/08/2015.
 */
public class AbstractTest extends Page{


    @AfterClass
    public void stopDriver(){
        stop();
    }

    public void stop(){
        driver.quit();
    }
}
