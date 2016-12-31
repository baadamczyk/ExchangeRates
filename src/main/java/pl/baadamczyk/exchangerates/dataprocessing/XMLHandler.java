package pl.baadamczyk.exchangerates.dataprocessing;

import com.sun.org.apache.xml.internal.security.encryption.Serializer;
import java.io.File;
import java.io.IOException;
import javax.swing.text.AbstractDocument;
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
public abstract class XMLHandler implements ContentAquirer {
    public NodeList createNodeList(File parsedFile, String rootTagName) throws ParserConfigurationException, SAXException, IOException {
        DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = builderFactory.newDocumentBuilder();            
        Document sourcesXML = documentBuilder.parse(parsedFile);
        
        return sourcesXML.getElementsByTagName(rootTagName);
    }
}
