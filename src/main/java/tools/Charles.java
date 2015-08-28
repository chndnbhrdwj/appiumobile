package tools;

import java.util.List;

/**
 * Created by cku04 on 26/08/2015.
 */
public class Charles {

    private static String charlesHost = "http://control.charles/";
    private static RestfulClient client = new RestfulClient();

    public static void startCharlesRecording() {
        String recordingStart = charlesHost + "recording/start";
        client.openConnection(recordingStart);
    }

    public static void stopCharlesRecording() {
        String recordingStop = charlesHost + "recording/stop";
        client.openConnection(recordingStop);
    }

    public static boolean clearCharlesSession() {
        String clearSession = charlesHost + "session/clear";
        return client.openConnection(clearSession);
    }

    public static List<String> parseCharlesSession(String xpath) {
        String endpoint = charlesHost + "session/export-xml";
        return client.get(endpoint, xpath);
    }

}
