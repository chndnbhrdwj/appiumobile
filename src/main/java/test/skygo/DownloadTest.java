package test.skygo;

import core.Testcase;
import org.junit.Test;
import pageobjects.mainpages.HomePage;

/**
 * Created by cku04 on 11/09/2015.
 */
public class DownloadTest extends Testcase {

    @Test
    public void downloadTest() {
        new HomePage()
                .goToSkyMoviesPage()
                .clickShowcase()
                .downloadProgram();
    }
}
