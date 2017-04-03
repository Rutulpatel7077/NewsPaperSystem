/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *
 * @author Rutul
 */
public class Parser {
    
    private final Document document;
    
    public Parser(String u) throws MalformedURLException, SAXException, IOException, ParserConfigurationException {
        URL url = new URL(u);
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
        this.document = documentBuilder.parse(url.openStream());
        this.document.getDocumentElement().normalize();
    }    
    
    public void getDocument() {
        System.out.println(document.getDocumentElement().getNodeName());
    }
    
    public String getHeadline() {
        NodeList nodeList = document.getElementsByTagName("item");
        Element node = (Element) nodeList.item(0);
        Node title = node.getElementsByTagName("title").item(0);
        return title.getTextContent().trim();
    }
}
