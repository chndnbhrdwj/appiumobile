package test.skygo;

import core.Testcase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import tools.Charles;
import tools.Common;

/**
 * Created by cku04 on 27/08/2015.
 */
public class FreeWheelTest extends Testcase {

    String xpathExpression = "//temporalAdSlot[@adUnit='Standard Pre']";

    @Before
    public void setUp() throws Exception {
        NodeList list = Common.stopRecordingParseCharlesSession(xpathExpression);
        for (int f = 0; f < list.getLength(); f++) {
            Node node = list.item(f);
            log.info(node.getNodeName() + " " + node.getAttributes().getNamedItem("timePositionClass"));
        }
    }

    @Test
    public void testCharles() {
        log.info("In Test");
        
    }

    @After
    public void tearOff() {
        Charles.stopCharlesRecording();
    }
}
