package test.skygo;

import org.apache.commons.exec.CommandLine;
import org.apache.commons.exec.DefaultExecuteResultHandler;
import org.apache.commons.exec.DefaultExecutor;
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

    public void startCharles() {
        execute("open /Applications/Charles.app");
    }

    public void startAppium() {
        try {
            CommandLine command = new CommandLine("/Applications/Appium.app/Contents/Resources/node/bin/node");
            command.addArgument("/Applications/Appium.app/Contents/Resources/node_modules/appium/bin/appium.js", false);
            command.addArgument("--address", false);
            command.addArgument("127.0.0.1");
            command.addArgument("--port", false);
            command.addArgument("4723");
            command.addArgument("--no-reset", false);
            DefaultExecuteResultHandler resultHandler = new DefaultExecuteResultHandler();
            DefaultExecutor executor = new DefaultExecutor();
            executor.setExitValue(1);
            executor.execute(command, resultHandler);
        } catch (Exception e) {
            System.out.println("Couldn't start appium server");
            e.printStackTrace();
        }
    }

    public void install() throws Exception {
        execute("adb install SkyGo.apk");
    }

    public void installProxyApp() throws Exception {
        execute("adb install proxy-setter-release-0.1.3.apk");
    }

    public void setProxy() throws Exception {
        execute("adb shell am start -n tk.elevenk.proxysetter/.MainActivity -e host 10.65.84.121 -e port 8090 -e bypass 127.0.0.1 -e ssid skygoandroid -e key goandr0id");
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
