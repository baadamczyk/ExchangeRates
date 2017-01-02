package pl.baadamczyk.exchangerates.dataprocessing;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
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
    
    public InputStream getXMLStream(URL url) {
        InputStream xmlStream = null;
        
        try {
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Accept", "application/xml");
            connection.setReadTimeout(5000);
            xmlStream = connection.getInputStream();
        } catch (IOException iOException) {
            System.out.println("ioException in getXMLStream");
        }
        
        return xmlStream;
    }
   
    public NodeList createNodeList(File parsedFile, String rootTagName) throws ParserConfigurationException, SAXException, IOException {
        DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = builderFactory.newDocumentBuilder();            
        Document sourcesXML = documentBuilder.parse(parsedFile);
        
        return sourcesXML.getElementsByTagName(rootTagName);
    }
    
    public NodeList createNodeList(InputStream parsedFileStream, String rootTagName) throws ParserConfigurationException, SAXException, IOException {
        DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = builderFactory.newDocumentBuilder();            
        Document sourcesXML = documentBuilder.parse(parsedFileStream);
        
        return sourcesXML.getElementsByTagName(rootTagName);
    }
}
