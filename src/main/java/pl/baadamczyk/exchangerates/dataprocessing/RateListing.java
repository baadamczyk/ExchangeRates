package pl.baadamczyk.exchangerates.dataprocessing;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

/**
 * @author baadamczyk
 */
public class RateListing extends ArrayList<ExchangeRate> implements Serializable {

    private static final long serialVersionUID = 1L;
        
    private String SourceName;
    private String SourceAddress;
    private Date PublicationDate;
    private String BaseCurrency;

    public RateListing() {
    }

    public RateListing(String SourceName, String SourceAddress, Date PublicationDate, String BaseCurrency) {
        this.SourceName = SourceName;
        this.SourceAddress = SourceAddress;
        this.PublicationDate = PublicationDate;
        this.BaseCurrency = BaseCurrency;
    }

    public String getSourceName() {
        return SourceName;
    }

    public void setSourceName(String SourceName) {
        this.SourceName = SourceName;
    }

    public String getSourceAddress() {
        return SourceAddress;
    }

    public void setSourceAddress(String SourceAddress) {
        this.SourceAddress = SourceAddress;
    }   

    public Date getPublicationDate() {
        return PublicationDate;
    }

    public void setPublicationDate(Date PublicationDate) {
        this.PublicationDate = PublicationDate;
    }        

    public String getBaseCurrency() {
        return BaseCurrency;
    }

    public void setBaseCurrency(String BaseCurrency) {
        this.BaseCurrency = BaseCurrency;
    }
}
