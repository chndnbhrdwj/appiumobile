package core;

import org.junit.After;
import pageobjects.mainpages.Page;

/**
 * Created by cku04 on 26/08/2015.
 */
public class Testcase extends Page {


    @After
    public void stopDriver() {
        driver.quit();
    }

}
