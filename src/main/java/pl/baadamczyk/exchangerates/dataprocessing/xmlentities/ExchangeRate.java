package pl.baadamczyk.exchangerates.dataprocessing.xmlentities;

import java.io.Serializable;

/**
 *
 * @author baadamczyk
 */
public class ExchangeRate implements Serializable {

    private static final long serialVersionUID = -3331391547734888233L;
    
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
