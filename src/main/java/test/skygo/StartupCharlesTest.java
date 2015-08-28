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

    List<String> assetFiles;
    String assetServer = "assets.mobile-tv.sky.com";
    String path = "/skygo/config/android";
    String termsConditions = path + "/help/Terms.html";
    String genres = path + "/genres.json";
    String marketing = path + "/Marketing/Marketing.json";
    String extra = path + "/help/faq-download-android.html";
    String faq = path + "/help/faq-android-singleapp.html";
    String config = path + "/config/Play-" + props.getPropertyValue("AppVersion") + ".json";

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
        verifyConfig();
        verifyGenres();
        verifyMarketing();
        verifyFaq();
        verifyTermsConditions();
        verifyExtras();
    }

    public void verifyConfig() {
        Assert.assertTrue("Config file not found as expected: ",
                assetFiles.contains(config));
    }

    public void verifyGenres() {
        Assert.assertTrue("Genres file not found as expected: ",
                assetFiles.contains(genres));
    }

    public void verifyMarketing() {
        Assert.assertTrue("Marketing file not found as expected: ",
                assetFiles.contains(marketing));
    }

    public void verifyFaq() {
        Assert.assertTrue("Faq was not found as expected: ",
                assetFiles.contains(faq));
    }

    public void verifyTermsConditions() {
        Assert.assertTrue("Terms and Conditions was not found as expected: ",
                assetFiles.contains(termsConditions));
    }

    public void verifyExtras() {
        Assert.assertTrue("Extras not found as expected: ",
                assetFiles.contains(extra));
    }

}
