package pl.baadamczyk.exchangerates.dataprocessing.xmlentities;

/**
 *
 * @author baadamczyk
 */
public class ExchangeRate {
    
    private String Name;
    private double Value;

    public ExchangeRate() {
    }

    public ExchangeRate(String Name, double Value) {
        this.Name = Name;
        this.Value = Value;
    }
    
    public ExchangeRate(String Name, String Value) {
        this.Name = Name;
        this.Value = Double.parseDouble(Value);
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public double getValue() {
        return Value;
    }

    public void setValue(double Value) {
        this.Value = Value;
    }    
}
