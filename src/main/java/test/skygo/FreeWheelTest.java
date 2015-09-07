package test.skygo;

import core.Testcase;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import tools.Charles;

/**
 * Created by cku04 on 27/08/2015.
 */
public class FreeWheelTest extends Testcase {

    Node preRollNode;
    Node midRollNode;
    String responseBodyExpression = "//transaction[contains(@host,'fwmrm.net')]/response/body/text()";
    String xpathExpression = "//temporalAdSlot[@adUnit='Standard Pre' or @adUnit='Standard Mid']";
    String timePosition = "";

    @Before
    public void getFreeWheelNodes() {
        NodeList nodeList = Charles.parseCharlesForFreeWheel(responseBodyExpression, xpathExpression);
        if (nodeList.getLength() < 1)
            log.info("Expected nodes were not found in charles session");
        Node node = nodeList.item(0).getParentNode();
        String adUnit = "Standard Pre";
        String actualAdUnit = node.getAttributes().getNamedItem("adUnit").getTextContent();
        if (adUnit.equals(actualAdUnit)) {
            preRollNode = node;
        } else {
            midRollNode = node;
        }
    }

    @Test
    public void verifyConviva() throws Exception {
        new ConvivaTest().getConvivaRequestBody();
    }

    @Test
    public void verifyComscore() throws Exception {
        new ComscoreTest().testIt();
    }

    public void verifyFreeWheelMidRollCall() {
        log.info("");
        if (midRollNode != null) {
            timePosition = midRollNode.getAttributes().getNamedItem("timePositionClass").getTextContent();
        }
        Assert.assertTrue("MidRoll ads were not found in Charles response.", timePosition.equalsIgnoreCase("midroll"));
    }

    @Test
    public void verifyFreeWheelPreRollCall() {
        log.info("");
        if (preRollNode != null) {
            timePosition = preRollNode.getAttributes().getNamedItem("timePositionClass").getTextContent();
        }
        Assert.assertTrue("PreRoll ads were not found in Charles response.", timePosition.equals("preroll"));
    }



    @After
    public void tearOff() {
        Charles.stopCharlesRecording();
    }
}
