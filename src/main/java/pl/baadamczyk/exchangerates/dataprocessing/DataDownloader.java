package pl.baadamczyk.exchangerates.dataprocessing;

import java.io.IOException;
import java.net.MalformedURLException;
import pl.baadamczyk.exchangerates.dataprocessing.xmlentities.DataSource;
import java.util.ArrayList;

/**
 *
 * @author baadamczyk
 */
public class DataDownloader  { //extends XMLHandler {
    
    private ArrayList<DataSource> SourcesList = new ArrayList<>();
    private RateListing rateListing;

    public DataDownloader() {
        SourcesManager sourcesManager = new SourcesManager();
        SourcesList = sourcesManager.getSourceList();
    }

    public RateListing getRateListing() {
        return rateListing;
    }
    
    private void checkSourcesAvailability() throws MalformedURLException, IOException {
        
           
            //in other case - check next source from list
            //store index of first available source in a property (!)
            // (should be moved to sources manager)
        }
    
    
   
}
