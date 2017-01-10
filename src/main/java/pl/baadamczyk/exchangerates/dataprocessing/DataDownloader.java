package pl.baadamczyk.exchangerates.dataprocessing;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import pl.baadamczyk.exchangerates.dataprocessing.xmlentities.DataSource;
import java.util.ArrayList;
import java.util.Date;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.DOMException;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import pl.baadamczyk.exchangerates.dataprocessing.xmlentities.ExchangeRate;
import pl.baadamczyk.exchangerates.serialization.ObjectSerializer;

/**
 *
 * @author baadamczyk
 */
public class DataDownloader extends XMLHandler {
    
    private ArrayList<DataSource> SourcesList = new ArrayList<>();
    private RateListing rateListing = new RateListing();

    public DataDownloader() {
        SourcesManager sourcesManager = new SourcesManager();
        SourcesList = sourcesManager.getSourceList();
        createRateListing();
        serializeInitialRateListing();
    }

    public RateListing getRateListing() {
        return rateListing;
    }
    
    private void createRateListing() {
           
           for(DataSource source : SourcesList) {                
               if(!source.isIsAvailable()) break;
               else {                           
                   try {
                       InputStream xml = getXMLStream(new URL(source.getAddress()));
                       NodeList rateNodeList = createNodeList(xml, "Cube");
                       setRateListingParameters(source, rateNodeList);
                       aquireContent(rateNodeList);                       
                   } catch (ParserConfigurationException | SAXException | IOException ex) {                  
                   }
               }
           }            
        }  

    @Override
    public void aquireContent(NodeList SourceNodeList) {
        for(int i=2; i < SourceNodeList.getLength(); i++) {
            Node ElementNode = SourceNodeList.item(i);
            
            if(ElementNode.getNodeType() == Node.ELEMENT_NODE) {
                Element RateElement = (Element) ElementNode;                               
                
                String currency = RateElement.getAttribute("currency");
                String rate = RateElement.getAttribute("rate");
                
                rateListing.add(new ExchangeRate(currency, rate));                                
            }
        }
    }

    private void setRateListingParameters(DataSource source, NodeList nodeList) {
                
        Date ListingDate = getListingDate(nodeList);               
        String SourceName = source.getName();
        String SourceAddress = source.getAddress();
        String BaseUnit = source.getBaseUnit();
        
        rateListing.setBaseCurrency(BaseUnit);
        rateListing.setPublicationDate(ListingDate);
        rateListing.setSourceAddress(SourceAddress);
        rateListing.setSourceName(SourceName);               
    }

    private Date getListingDate(NodeList nodeList) {
        try {
            String ListingDateString = nodeList.item(1).getAttributes().item(0).getNodeValue();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            return dateFormat.parse(ListingDateString);
        } catch (DOMException | ParseException ex) {
            return null;
        }
    }

    private void serializeInitialRateListing() {
        ObjectSerializer.serializeObject(rateListing, "initialRateListing");
    }
}
