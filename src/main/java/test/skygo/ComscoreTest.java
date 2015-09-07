package test.skygo;

import core.Testcase;
import org.junit.Assert;
import org.junit.Test;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import tools.Charles;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cku04 on 07/09/2015.
 */
public class ComscoreTest extends Testcase {

    String comscoreQueryXpath = "//transaction[contains(@host,'b.scorecardresearch.com')]";
    List<String> query;
    NodeList comscoreCalls;

    @Test
    public void testIt() throws Exception {
        comscoreCalls = Charles.parseCharlesForComscore(comscoreQueryXpath);
        query = new ArrayList<String>();

        /*RestfulClient client= new RestfulClient();

        Document doc=client.convertStringToDocument(Dummy.xml);

        xpath = XPathFactory.newInstance().newXPath();
        comscoreCalls = (NodeList) xpath.compile(comscoreQueryXpath).evaluate(doc, XPathConstants.NODESET);
*/

        for (int f = 0; f < comscoreCalls.getLength(); f++) {
            Node node = comscoreCalls.item(f);
            query.add(node.getAttributes().getNamedItem("query").toString());

        }
        if (advertDisplayed) {
            Assert.assertTrue("Advert Play call was not found.", query.get(0).contains("ns_st_ev=ad_play"));
            Assert.assertTrue("Advert End call was not found.", query.get(1).contains("ns_st_ev=ad_end"));
        }
        if (videoDisplayed) {
            Assert.assertTrue("Content Play call was not found.", query.get(2).contains("ns_st_ev=play"));
            Assert.assertTrue("Content End call was not found.", query.get(3).contains("ns_st_ev=end"));
        }
    }
}
