package test.skygo;

import core.Testcase;
import org.junit.Before;
import org.junit.Test;
import tools.Common;

import java.util.List;

/**
 * Created by cku04 on 27/08/2015.
 */
public class FreeWheelTest extends Testcase {

    List<String> assetFiles;

    private List<String> getAssetFiles(String resource) {
        return Common.stopRecordingParseCharlesSession(resource);
    }

    @Before
    public void setUp() {
        String freeWheelNode = "//transaction[contains(@host,'fwmrm.net')]/response/body";
        assetFiles = getAssetFiles(freeWheelNode);
        String body = assetFiles.toString();
    }

    @Test
    public void testCharles() {
    }


}
