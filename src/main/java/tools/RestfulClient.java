package tools;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
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
    XPath xpath;

    public NodeList getAssets(String endpoint, String xpathExpression) {
        NodeList nl = getNodeList(doc, endpoint, xpathExpression);
        return nl;
    }

    public Node getNode(Document document, String endpoint, String xpathExpression) {
        Node node = null;
        try {
            doc = document == null ? getDocument(endpoint) : document;
            xpath = XPathFactory.newInstance().newXPath();
            node = (Node) xpath.compile(xpathExpression).evaluate(doc, XPathConstants.NODE);
        } catch (XPathExpressionException e) {
            e.getMessage();
        }
        return node;
    }

    public NodeList getNodeList(Document document, String endpoint, String xpathExpression) {
        NodeList nodeList = null;
        try {
            doc = document == null ? getDocument(endpoint) : document;
            xpath = XPathFactory.newInstance().newXPath();
            nodeList = (NodeList) xpath.compile(xpathExpression).evaluate(doc, XPathConstants.NODESET);
        } catch (XPathExpressionException e) {
            e.getMessage();
        }
        return nodeList;
    }

    public Document getDocument(String endpoint) {
        try {
            if (openConnection(endpoint)) {
                InputStream is = conn.getInputStream();

                DocumentBuilder dBuilder = DocumentBuilderFactory
                        .newInstance()
                        .newDocumentBuilder();

                doc = dBuilder.parse(is);
            }
        } catch (Exception e) {
            e.getMessage();
        } finally {
            conn.disconnect();
        }
        return doc;
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
        } catch (Exception e) {
            e.getMessage();
            return false;
        }
        return true;
    }
}
