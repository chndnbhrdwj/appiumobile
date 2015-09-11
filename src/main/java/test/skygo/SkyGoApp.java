package test.skygo;

import org.apache.commons.io.FileUtils;
import tools.Jenkins;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

/**
 * Created by cku04 on 03/09/2015.
 */
public class SkyGoApp {

    URL url;
    File file;
    Process p;

    public void download() throws Exception {
        url = new URL(new Jenkins().getBuildUrl());
        file = new File("SkyGo.apk");
        FileUtils.copyURLToFile(url, file);
    }

    public void install() throws Exception {
        execute("adb install SkyGo.apk");
    }

    public void clear() throws Exception {
        execute("adb shell pm clear com.bskyb.skygo");
    }

    public void uninstall() throws Exception {
        execute("adb uninstall com.bskyb.skygo");
    }

    public void sendAdbEnterKey() {
        execute("adb shell input keyevent 66");
    }

    private void execute(String command) {
        try {
            p = Runtime.getRuntime().exec(command);
            p.waitFor();
        } catch (IOException e) {
            System.out.println("Couldn't send the command " + command);
        } catch (InterruptedException e) {
            System.out.println("Something wrong happened while waiting for command result " + command);
        }
    }

    private String executeCommand(String command) {
        StringBuffer output = new StringBuffer();
        Process p;
        try {
            p = Runtime.getRuntime().exec(command);
            p.waitFor();
            BufferedReader reader =
                    new BufferedReader(new InputStreamReader(p.getInputStream()));
            String line = "";
            while ((line = reader.readLine()) != null) {
                output.append(line + "\n");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return output.toString();
    }
}
