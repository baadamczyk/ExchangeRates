/* @author baadamczyk */

package pl.baadamczyk.exchangerates.ui;

import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class EntryTile extends JPanel {

   private String CurrencyName;
   private String RateValue;
   private Color TextColor;

    public EntryTile() {
        this.CurrencyName = "PLN";
        this.RateValue = "9,99";
        this.TextColor = Color.BLACK;
        setTileLayout();
        addComponents();        
    }

    public EntryTile(String CurrencyName, String RateValue) {
        this.CurrencyName = CurrencyName;
        this.RateValue = RateValue; 
        this.TextColor = Color.BLACK;
        setTileLayout();
        addComponents(); 
    }
    
    public EntryTile(String CurrencyName, String RateValue, Color TextColor) {
        this.CurrencyName = CurrencyName;
        this.RateValue = RateValue;
        this.TextColor = TextColor;
        setTileLayout();
        addComponents(); 
    }

    private void setTileLayout() {
        this.setLayout(new GridLayout(1, 2));
        this.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
    }

    private void addComponents() {
        this.add(new JLabel(CurrencyName+"    "+RateValue) {
            @Override
            public void setHorizontalAlignment(int i) {
                super.setHorizontalAlignment(JLabel.CENTER);                
            }  

            @Override
            public void setForeground(Color color) {
                super.setForeground(TextColor);
            }                        
        });    
    }      
}
