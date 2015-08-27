package tools;

import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathFactory;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by cku04 on 21/08/2015.
 */
public class RestfulClient {

    HttpURLConnection conn;
    Document doc;

    public String get(String endpoint, String xpathExpression) {
        String value = "";
        try {
            if (openConnection(endpoint)) {
                InputStream is = conn.getInputStream();

                DocumentBuilder dBuilder = DocumentBuilderFactory
                        .newInstance()
                        .newDocumentBuilder();

                doc = dBuilder.parse(is);
            }
            XPath xpath = XPathFactory.newInstance().newXPath();
            value = xpath.compile(xpathExpression).evaluate(doc);
            conn.disconnect();
        } catch (Exception e) {
            e.getMessage();
        }
        return value;
    }


    public boolean openConnection(String endpoint) {
        try {
            URL url = new URL(endpoint);
            conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            if (conn.getResponseCode() != 200) {
                throw new RuntimeException("Failed : with error code : "
                        + conn.getResponseCode());
            }
            //conn.disconnect();
        } catch (Exception e) {
            e.getMessage();
            return false;
        }
        return true;
    }
}
