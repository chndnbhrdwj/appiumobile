package test.skygo;

import core.Testcase;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.w3c.dom.Node;
import tools.Charles;
import tools.StackTraceInfo;

/**
 * Created by cku04 on 27/08/2015.
 */
public class FreeWheelTest extends Testcase {

    String responseBodyExpression = "//transaction[contains(@host,'fwmrm.net')]/response/body/text()";
    String preRollXpathExpression = "//temporalAdSlot[@adUnit='Standard Pre']";
    String standardMidXpathExpression = "//temporalAdSlot[@adUnit='Standard Mid']";

    @Test
    public void verifyFreeWheelPreRollCall() {
        log.info(StackTraceInfo.getCurrentMethodName());
        Node node = Charles.parseCharlesForFreeWheel(responseBodyExpression, preRollXpathExpression);
        String timePosition = node.getAttributes().getNamedItem("timePositionClass").getTextContent();
        Assert.assertTrue("PreRoll ads were not found in Charles response.", timePosition.equals("preroll"));
    }

    @Test
    public void verifyFreeWheelMidRollCall() {
        log.info(StackTraceInfo.getCurrentMethodName());
        Node node = Charles.parseCharlesForFreeWheel(responseBodyExpression, standardMidXpathExpression);
        String timePosition = node.getAttributes().getNamedItem("timePositionClass").getTextContent();
        Assert.assertTrue("MidRoll ads were not found in Charles response.", timePosition.equalsIgnoreCase("midroll"));
    }


    @After
    public void tearOff() {
        Charles.stopCharlesRecording();
    }
}
