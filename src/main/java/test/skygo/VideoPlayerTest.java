package test.skygo;

import core.Testcase;
import org.junit.Before;
import org.junit.Test;
import pageobjects.mainpages.OnNowPage;
import tools.Common;

/**
 * Created by cku04 on 17/08/2015.
 */
public class VideoPlayerTest extends Testcase {

    @Before
    public void setUp() {
        Common.startRecordingClearCharlesSession();
    }

    @Test
    public void testIt() {
        verifyVodVideoPlayer();
    }

    public void verifyVodVideoPlayer() {
        new OnNowPage()
                .goToSkyMoviesPage()
                .clickShowcase()
                .watchProgram()
                .videoViewDisplayed()
                .backToProgramDetails()
                .goToOnNowPage()
                .clickShowcase()
                .watchProgram()
                .videoViewDisplayed()
                .backToProgramDetails()
                .goToOnNowPage();
    }
}
