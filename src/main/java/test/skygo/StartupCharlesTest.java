package test.skygo;

import core.Testcase;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import tools.Common;

import java.util.List;

/**
 * Created by cku04 on 27/08/2015.
 */
public class StartupCharlesTest extends Testcase {

    String assetServer = "assets.mobile-tv.sky.com";
    String genresFileName = "/skygo/config/android/genres.json";
    String marketingFileName = "/skygo/config/android/Marketing/Marketing.json";
    String configFileName = "/skygo/config/android/config/Play-" + props.getPropertyValue("AppVersion") + ".json";
    List<String> assetFiles;

    private List<String> getAssetFiles(String resource) {
        return Common.stopRecordingParseCharlesSession(resource);
    }

    @Before
    public void setUp() {
        String assetServerNodes = "//transaction[@host='" + assetServer + "']/response[@status='200']";
        assetFiles = getAssetFiles(assetServerNodes);
    }

    @Test
    public void testCharles() {
        verifyConfigFile();
        verifyGenresFile();
        verifyMarketingFile();
    }

    public void verifyConfigFile() {
        Assert.assertTrue("Config file version was not as expected: ",
                assetFiles.contains(configFileName));
    }

    public void verifyGenresFile() {
        Assert.assertTrue("Genres file was not as expected: ",
                assetFiles.contains(genresFileName));
    }

    public void verifyMarketingFile() {
        Assert.assertTrue("Marketing file was not as expected: ",
                assetFiles.contains(marketingFileName));
    }

}
