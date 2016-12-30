package pl.baadamczyk.exchangerates.dataprocessing;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 * @author baadamczyk
 */
public class SourceListXMLHandler extends XMLHandler {   
    
    private ArrayList<DataSource> SourceList = new ArrayList<>();
    
    public SourceListXMLHandler() {
        parseSourceList();
    }

    public ArrayList<DataSource> getSourceList() {
        return SourceList;
    }    

    private void parseSourceList() {                     
        try {
            NodeList SourceNodesList = createNodeList();
            aquireContent(SourceNodesList);                                          
        } catch (IOException | ParserConfigurationException | SAXException ex) {            
        }
    }

    private NodeList createNodeList() throws ParserConfigurationException, SAXException, IOException {
        DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = builderFactory.newDocumentBuilder();            
        Document sourcesXML = documentBuilder.parse(new File("src/main/resources/xml/Sources.xml"));
        
        return sourcesXML.getElementsByTagName("Source");
    }

    private void aquireContent(NodeList SourceNodesList) {
        
    for(int i=0; i< SourceNodesList.getLength(); i++) {
                Node ElementNode = SourceNodesList.item(i);
                
                if(ElementNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element SourceElement = (Element) ElementNode;                    
                    createSourcesList(SourceElement);                                                            
                }                                
            }
    }

    private void createSourcesList(Element SourceElement) {
        String SourceType = SourceElement.getElementsByTagName("Type").item(0).getTextContent();
        String SourceBaseUnit = SourceElement.getElementsByTagName("BaseUnit").item(0).getTextContent();
        String SourceName = SourceElement.getElementsByTagName("Name").item(0).getTextContent();
        String SourceAddress = SourceElement.getElementsByTagName("Address").item(0).getTextContent();
        SourceList.add(new DataSource(SourceType, SourceBaseUnit, SourceName, SourceAddress));
    }
}
