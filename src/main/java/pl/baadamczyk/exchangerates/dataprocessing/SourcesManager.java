package pl.baadamczyk.exchangerates.dataprocessing;

import pl.baadamczyk.exchangerates.dataprocessing.xmlentities.DataSource;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 * @author baadamczyk
 */
public class SourcesManager extends XMLHandler {   
    
    private ArrayList<DataSource> SourceList = new ArrayList<>();
    
    public SourcesManager() {
        parseSourceList();
    }

    public ArrayList<DataSource> getSourceList() {
        return SourceList;
    }    

    private void parseSourceList() {                     
        try {
            NodeList SourceNodesList = createNodeList(new File("src/main/resources/xml/Sources.xml"), "Source");
            aquireContent(SourceNodesList);                                          
        } catch (IOException | ParserConfigurationException | SAXException ex) {            
        }
    }
    
    @Override
    public void aquireContent(NodeList SourceNodesList) {
        
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
        checkSourcesAvailability();
    }
    
    private void checkSourcesAvailability() {
       
            for (DataSource source : SourceList) {

                HttpURLConnection connection = null;
                try {
                    
                    URL url = new URL(source.getAddress());
                    connection = (HttpURLConnection) url.openConnection();
                    connection.setRequestMethod("GET");
                    connection.setRequestProperty("Accept", "application/xml");
                    connection.setReadTimeout(5000);
                    InputStream xml = connection.getInputStream();
                    if (xml == null) source.setIsAvailable(false);
                    else source.setIsAvailable(true);
                    
                } catch (IOException iOException) {
                    source.setIsAvailable(false);
                }                          
            }        
    }
}
