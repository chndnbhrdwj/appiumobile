package test.skygo;

import core.Testcase;
import org.junit.Test;
import tools.Common;

/**
 * Created by cku04 on 27/08/2015.
 */
public class StartupTest extends Testcase {

    String xpath = "//transaction[@host='assets.mobile-tv.sky.com'][@path='/skygo/config/android/genres.json']/@remoteAddress";

    @Test
    public void startupTest() {
        log.info("Printing : " + Common.stopRecordingParseCharlesSession(xpath));

    }
}
