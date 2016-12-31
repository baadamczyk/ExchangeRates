package pl.baadamczyk.exchangerates.dataprocessing.xmlentities;

/**
 *
 * @author baadamczyk
 */
public class DataSource {
    private String Type;
    private String BaseUnit;
    private String Name;
    private String Address;
    private boolean IsAvailable;

    public DataSource(String Type, String BaseUnit, String Name, String Address) {
        this.Type = Type;
        this.BaseUnit = BaseUnit;
        this.Name = Name;
        this.Address = Address;
    }

    public String getType() {
        return Type;
    }

    public void setType(String Type) {
        this.Type = Type;
    }

    public String getBaseUnit() {
        return BaseUnit;
    }

    public void setBaseUnit(String BaseUnit) {
        this.BaseUnit = BaseUnit;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public boolean isIsAvailable() {
        return IsAvailable;
    }

    public void setIsAvailable(boolean IsAvailable) {
        this.IsAvailable = IsAvailable;
    }
}
