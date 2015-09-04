package test.skygo;

import core.Testcase;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.junit.Assert;
import tools.Charles;

/**
 * Created by cku04 on 03/09/2015.
 */
public class ConvivaTest extends Testcase {

    String requestBodyXpath = "//transaction[contains(@host,'cws.conviva.com')]/request/body/text()";

    String body;

    public void getConvivaRequestBody() throws Exception {
        String playerVersion = props.getPropertyValue("AppVersion");

        body = Charles.parseCharlesForConviva(requestBodyXpath);
        if (body == null)
            log.info("Conviva content was not found on Charles");

        JSONObject root = (JSONObject) new JSONParser().parse(body);
        JSONObject tags = (JSONObject) root.get("tags");

        Assert.assertTrue("Connection value in tags was not Wifi", tags.get("connection.stream.started.on").equals("wifi"));
        Assert.assertTrue("OutOfBrowser value in tags was not T", tags.get("outOfBrowser").equals("T"));
        Assert.assertTrue("PlayerVersion value in tags was not " + playerVersion, tags.get("playerVersion").equals(playerVersion));
        Assert.assertTrue("Connection value in tags was not Wifi", tags.get("connection.stream.started.on").equals("wifi"));

        JSONObject pm = (JSONObject) root.get("pm");

        Assert.assertTrue("Operating System value in pm was not AND", pm.get("os").equals("AND"));
        Assert.assertTrue("Device value in pm was not android", pm.get("dv").equals("android"));
        Assert.assertTrue("Device type value in pm was not Mobile", pm.get("dvt").equals("Mobile"));
        Assert.assertTrue("Operating System value in pm was not AND", pm.get("os").equals("AND"));
    }


}
