package core;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.Properties;

/**
 * Created by cku04 on 26/08/2015.
 */
public class SkygoProperties extends Properties {
    static OutputStream output = null;
    private static String propertyFile = "skygo.properties";
    private static Properties properties = new Properties();

    protected static String getPropertyValue(String property) {
        String value = "";
        try {
            properties.load(new FileInputStream(propertyFile));
            value = properties.getProperty(property);
        } catch (Exception e) {
            e.getMessage();
        }

        return value;
    }

    protected static void putProperty(String property, String value) {
        try {
            output = new FileOutputStream(propertyFile);
            properties.setProperty(property, value);
            properties.store(output, null);
        } catch (Exception e) {
            e.getMessage();
        }
    }
}
