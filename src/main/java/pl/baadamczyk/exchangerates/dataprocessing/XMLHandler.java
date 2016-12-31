package pl.baadamczyk.exchangerates.dataprocessing;

import java.io.File;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *
 * @author baadamczyk
 */
public class XMLHandler {
    public NodeList createNodeList(File parsedFile, String rootTagName) throws ParserConfigurationException, SAXException, IOException {
        DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = builderFactory.newDocumentBuilder();            
        Document sourcesXML = documentBuilder.parse(parsedFile);
        
        return sourcesXML.getElementsByTagName(rootTagName);
    }
}
