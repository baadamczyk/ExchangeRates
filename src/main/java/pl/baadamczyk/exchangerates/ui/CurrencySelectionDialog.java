package pl.baadamczyk.exchangerates.ui;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import javax.swing.DefaultComboBoxModel;
import pl.baadamczyk.exchangerates.dataprocessing.RateListing;
import pl.baadamczyk.exchangerates.dataprocessing.xmlentities.ExchangeRate;

/**
 *
 * @author baadamczyk
 */
public class CurrencySelectionDialog extends Window {
    
    private RateListing rateListing;
    

    public CurrencySelectionDialog(RateListing rateListing, ActionListener parentFrame) {
        super(220, 70, "Currency selection");
        initComponents();        
        this.rateListing = rateListing;
        setCurrencySelectionComboboxModel();
        AcceptButton.addActionListener(parentFrame);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        AcceptButton = new javax.swing.JButton();
        CurrencySelectionCombobox = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        AcceptButton.setText("Accept");
        AcceptButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AcceptButtonActionPerformed(evt);
            }
        });

        CurrencySelectionCombobox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(CurrencySelectionCombobox, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addComponent(AcceptButton)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(AcceptButton)
                    .addComponent(CurrencySelectionCombobox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void AcceptButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AcceptButtonActionPerformed
       changeCurrency(getSelectedCurrencyName());               
    }//GEN-LAST:event_AcceptButtonActionPerformed
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AcceptButton;
    private javax.swing.JComboBox<String> CurrencySelectionCombobox;
    // End of variables declaration//GEN-END:variables

    private void setCurrencySelectionComboboxModel() {
        ArrayList<String> currencyNames = createCurrencyNamesList();                       
        DefaultComboBoxModel model = new DefaultComboBoxModel(currencyNames.toArray());
        
        CurrencySelectionCombobox.setModel(model);
    }

    private ArrayList<String> createCurrencyNamesList() {        
        ArrayList<String> currencyNames = new ArrayList<>();    
        
        for(ExchangeRate rate : rateListing) {
            currencyNames.add(rate.getName());
        }        
        
        sortCurrencyNamesList(currencyNames);
        return currencyNames;        
    }

    private void sortCurrencyNamesList(ArrayList<String> currencyNames) {
        Collections.sort(currencyNames, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }            
        });
    }
    
    private String getSelectedCurrencyName() {
        return CurrencySelectionCombobox.getSelectedItem().toString();
    }

    private void changeCurrency(String targetCurrencySymbol) {                
        double targetRateInEur = getTargetCurrencyValueInEur(targetCurrencySymbol);
        RateListing newListing = buildConvertedRateListing(targetCurrencySymbol, targetRateInEur);                      
        refreshData(newListing);
    }   

    private double getTargetCurrencyValueInEur(String targetCurrencySymbol) {
        for(ExchangeRate rate : rateListing) {
           if(rate.getName().equals(targetCurrencySymbol)) {
               return rate.getValue();
           } 
        }
        return 0;
    }

    private RateListing buildConvertedRateListing(String targetCurrencySymbol, double targetRateInEur) {
        RateListing newListing = new RateListing(targetCurrencySymbol);
        
        for(ExchangeRate rate : rateListing) {
           ExchangeRate newRate = new ExchangeRate();
           double newRateValue = 0;
           
           if(rate.getName().equals(targetCurrencySymbol)) {
               newRate.setName(rateListing.getBaseCurrency());
               newRateValue = (1/targetRateInEur);
           } else {                          
               newRateValue = rate.getValue() / targetRateInEur;               
               newRate.setName(rate.getName());               
           }
           
           newRate.setValue(newRateValue);
           newListing.add(newRate);                      
       }
        return newListing;
    }
}
