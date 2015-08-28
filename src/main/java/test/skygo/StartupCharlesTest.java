package test.skygo;

import core.Testcase;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import tools.Charles;
import tools.Common;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cku04 on 27/08/2015.
 */
public class StartupCharlesTest extends Testcase {

    List<String> assetsList;
    String assetServer = "assets.mobile-tv.sky.com";
    String path = "/skygo/config/android";
    String termsConditions = path + "/help/Terms.html";
    String genres = path + "/genres.json";
    String marketing = path + "/Marketing/Marketing.json";
    String extra = path + "/help/faq-download-android.html";
    String faq = path + "/help/faq-android-singleapp.html";
    String config = path + "/config/Play-" + props.getPropertyValue("AppVersion") + ".json";

    private NodeList getAssetFiles(String resource) {
        return Common.stopRecordingParseCharlesSession(resource);
    }


    @Before
    public void setUp() {
        assetsList = new ArrayList();
        String assetServerNodes = "//transaction[@host='" + assetServer + "']/response[@status='200']";
        NodeList assetFiles = getAssetFiles(assetServerNodes);
        if (assetFiles.getLength() < 1) {
            System.out.println("Asset document did not returned the filenames.");
        }
        for (int n = 0; n < assetFiles.getLength(); n++) {
            Node node = assetFiles.item(n);
            assetsList.add(node.getParentNode().getAttributes().getNamedItem("path").getNodeValue());
        }
    }

    @Test
    public void testAssets() {
        verifyExtras();
        verifyFaq();
        verifyTermsConditions();
        verifyConfig();
        verifyGenres();
        verifyMarketing();
    }

    public void verifyConfig() {
        Assert.assertTrue("Config file not found as expected: ",
                assetsList.contains(config));
    }

    public void verifyGenres() {
        Assert.assertTrue("Genres file not found as expected: ",
                assetsList.contains(genres));
    }

    public void verifyMarketing() {
        Assert.assertTrue("Marketing file not found as expected: ",
                assetsList.contains(marketing));
    }

    public void verifyFaq() {
        Assert.assertTrue("Faq was not found as expected: ",
                assetsList.contains(faq));
    }

    public void verifyTermsConditions() {
        Assert.assertTrue("Terms and Conditions was not found as expected: ",
                assetsList.contains(termsConditions));
    }

    public void verifyExtras() {
        Assert.assertTrue("Extras not found as expected: ",
                assetsList.contains(extra));
    }

    @After
    public void tearOff() {
        Charles.stopCharlesRecording();
    }


}
