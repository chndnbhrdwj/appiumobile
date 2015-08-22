package tools;

import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Node;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by cku04 on 21/08/2015.
 */
public class RestfulClient {

@Test
    public void get() {

        try {
            URL url = new URL("http://www.w3schools.com/xml/note.xml");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");

            if (conn.getResponseCode() != 200) {
                throw new RuntimeException("Failed : HTTP error code : "
                        + conn.getResponseCode());
            }

            InputStream is = conn.getInputStream();

            DocumentBuilder dBuilder = DocumentBuilderFactory
                    .newInstance()
                    .newDocumentBuilder();
            Document doc = dBuilder.parse(is);


            XPath xpath = XPathFactory.newInstance().newXPath();
            String expression= "/note/from/text()";
            String text=xpath.compile(expression).evaluate(doc);
            System.out.println(text);

            conn.disconnect();
        } catch (Exception e) {
            e.getMessage();
        }
    }
}
