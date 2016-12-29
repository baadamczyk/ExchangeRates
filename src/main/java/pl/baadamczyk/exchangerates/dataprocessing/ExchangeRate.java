package pl.baadamczyk.exchangerates.dataprocessing;

/**
 *
 * @author baadamczyk
 */
public class ExchangeRate {
    
    private String Name;
    private String Value;

    public ExchangeRate() {
    }

    public ExchangeRate(String Name, String Value) {
        this.Name = Name;
        this.Value = Value;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getValue() {
        return Value;
    }

    public void setValue(String Value) {
        this.Value = Value;
    }    
}
