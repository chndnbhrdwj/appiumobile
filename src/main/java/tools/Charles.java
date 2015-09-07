package tools;

import org.w3c.dom.NodeList;

/**
 * Created by cku04 on 26/08/2015.
 */
public class Charles {

    private static String charlesHost = "http://control.charles/";
    private static RestfulClient client = new RestfulClient();

    public static String getCharlesEndpoint() {
        return charlesHost + CharlesEndpoints.GET_SESSION;
    }

    public static void startCharlesRecording() {
        String recordingStart = charlesHost + CharlesEndpoints.START_RECORDING;
        client.openConnection(recordingStart);
    }

    public static void stopCharlesRecording() {
        String recordingStop = charlesHost + CharlesEndpoints.STOP_RECORDING;
        client.openConnection(recordingStop);
    }

    public static boolean clearCharlesSession() {
        String clearSession = charlesHost + CharlesEndpoints.CLEAR_SESSION;
        return client.openConnection(clearSession);
    }

    public static NodeList parseCharlesSession(String xpath) {
        String endpoint = charlesHost + CharlesEndpoints.GET_SESSION;
        return client.getAssets(endpoint, xpath);
    }

    public static NodeList parseCharlesForFreeWheel(String xpath, String bodyXpathExpression) {
        String endpoint = charlesHost + CharlesEndpoints.GET_SESSION;
        return client.getFreeWheelNode(null, endpoint, xpath, bodyXpathExpression);
    }

    public static String parseCharlesForConviva(String xpath) {
        String endpoint = charlesHost + CharlesEndpoints.GET_SESSION;
        return client.getText(null, endpoint, xpath);
    }

    public static NodeList parseCharlesForComscore(String xpath) {
        String endpoint = charlesHost + CharlesEndpoints.GET_SESSION;
        return client.getAssets(endpoint, xpath);
    }

    public enum CharlesEndpoints {

        GET_SESSION("session/export-xml"),
        START_RECORDING("recording/start"),
        STOP_RECORDING("recording/stop"),
        CLEAR_SESSION("session/clear");

        private String endpoint;

        CharlesEndpoints(String s) {
            endpoint = s;
        }

        public String toString() {
            return endpoint;
        }
    }

}
