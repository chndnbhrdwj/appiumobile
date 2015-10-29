package tools;

import core.SkygoProperties;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.Test;

/**
 * Created by cku04 on 04/09/2015.
 */
public class Jenkins {

    String url;
    SkygoProperties props;

    @Test
    public void testIt() {
        System.out.println(getBuildUrl());
    }


    public String getBuildUrl() {
        props = new SkygoProperties();
        url = "http://172.20.141.64:9090/job/" + props.getPropertyValue("JenkinsBuild") + "/api/json?pretty=true";
        String path = "";
        String stableBuildResponse = new RestfulClient().getJsonResponse(url);
        try {
            JSONObject root = (JSONObject) new JSONParser().parse(stableBuildResponse);
            JSONObject lastStableBuild = (JSONObject) root.get("lastStableBuild");
            String stableUrl = (String) lastStableBuild.get("url");
            String stableUrlCorrectedPort = stableUrl.replace("8080", "9090");

            String releaseSignedApkResponse = new RestfulClient().getJsonResponse(stableUrlCorrectedPort.concat("api/json?pretty=true"));
            JSONObject buildRoot = (JSONObject) new JSONParser().parse(releaseSignedApkResponse);
            JSONArray buildsArray = (JSONArray) buildRoot.get("artifacts");

            for (Object obj : buildsArray) {
                JSONObject jsonObj = (JSONObject) obj;
                if (jsonObj.get("fileName").toString().equals(props.getPropertyValue("BuildName")))
                    path = (String) jsonObj.get("relativePath");
            }
            path = stableUrlCorrectedPort + "artifact/" + path;
        } catch (ParseException e) {
            System.out.println("Json response was not found as expected.");
        }
        return path;
    }
}
