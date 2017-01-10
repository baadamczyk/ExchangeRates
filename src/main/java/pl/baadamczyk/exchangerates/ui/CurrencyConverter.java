package pl.baadamczyk.exchangerates.ui;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import javax.swing.DefaultComboBoxModel;
import pl.baadamczyk.exchangerates.dataprocessing.RateListing;
import pl.baadamczyk.exchangerates.dataprocessing.xmlentities.ExchangeRate;
import pl.baadamczyk.exchangerates.serialization.ObjectSerializer;

/**
 *
 * @author baadamczyk
 */
public class CurrencyConverter extends Window {

    RateListing listing;
    
    public CurrencyConverter() {
        super(400, 185, "Currency converter");
        initComponents();
        getInitialListing();                               
        setComboboxModels();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        SourcePanel = new javax.swing.JPanel();
        SourceValueLabel = new javax.swing.JLabel();
        SourceCurrencyCombobox = new javax.swing.JComboBox<>();
        SourceValueTexfield = new javax.swing.JTextField();
        TargetPanel = new javax.swing.JPanel();
        TargetValueLabel = new javax.swing.JLabel();
        TargetCurrencyCombobox = new javax.swing.JComboBox<>();
        TargetValueTexfield = new javax.swing.JTextField();
        ControlPanel = new javax.swing.JPanel();
        ResetButton = new javax.swing.JButton();
        ConvertButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        SourcePanel.setPreferredSize(new java.awt.Dimension(490, 40));

        SourceValueLabel.setText("Source value: ");

        SourceCurrencyCombobox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        SourceValueTexfield.setMaximumSize(TargetValueTexfield.getPreferredSize());
        SourceValueTexfield.setMinimumSize(TargetValueTexfield.getPreferredSize());
        SourceValueTexfield.setPreferredSize(new java.awt.Dimension(135, 20));

        javax.swing.GroupLayout SourcePanelLayout = new javax.swing.GroupLayout(SourcePanel);
        SourcePanel.setLayout(SourcePanelLayout);
        SourcePanelLayout.setHorizontalGroup(
            SourcePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SourcePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(SourceValueLabel)
                .addGap(18, 18, 18)
                .addComponent(SourceValueTexfield, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(SourceCurrencyCombobox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        SourcePanelLayout.setVerticalGroup(
            SourcePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SourcePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(SourcePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SourceValueLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SourceCurrencyCombobox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SourceValueTexfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(9, Short.MAX_VALUE))
        );

        TargetPanel.setPreferredSize(new java.awt.Dimension(490, 40));

        TargetValueLabel.setText("Source value: ");

        TargetCurrencyCombobox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        TargetValueTexfield.setMaximumSize(TargetValueTexfield.getPreferredSize());
        TargetValueTexfield.setMinimumSize(TargetValueTexfield.getPreferredSize());
        TargetValueTexfield.setPreferredSize(new java.awt.Dimension(135, 22));

        javax.swing.GroupLayout TargetPanelLayout = new javax.swing.GroupLayout(TargetPanel);
        TargetPanel.setLayout(TargetPanelLayout);
        TargetPanelLayout.setHorizontalGroup(
            TargetPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TargetPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(TargetValueLabel)
                .addGap(18, 18, 18)
                .addComponent(TargetValueTexfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TargetCurrencyCombobox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        TargetPanelLayout.setVerticalGroup(
            TargetPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TargetPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(TargetPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(TargetPanelLayout.createSequentialGroup()
                        .addComponent(TargetValueTexfield, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(3, 3, 3))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, TargetPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(TargetValueLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(TargetCurrencyCombobox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(9, Short.MAX_VALUE))
        );

        ResetButton.setText("Reset");
        ResetButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ResetButtonActionPerformed(evt);
            }
        });

        ConvertButton.setText("Convert");
        ConvertButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ConvertButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout ControlPanelLayout = new javax.swing.GroupLayout(ControlPanel);
        ControlPanel.setLayout(ControlPanelLayout);
        ControlPanelLayout.setHorizontalGroup(
            ControlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ControlPanelLayout.createSequentialGroup()
                .addGap(76, 76, 76)
                .addComponent(ResetButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                .addComponent(ConvertButton, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(76, 76, 76))
        );
        ControlPanelLayout.setVerticalGroup(
            ControlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ControlPanelLayout.createSequentialGroup()
                .addGroup(ControlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ResetButton)
                    .addComponent(ConvertButton))
                .addGap(12, 12, 12))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TargetPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 344, Short.MAX_VALUE)
                    .addComponent(SourcePanel, javax.swing.GroupLayout.DEFAULT_SIZE, 344, Short.MAX_VALUE)
                    .addComponent(ControlPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(SourcePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TargetPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ControlPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ResetButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ResetButtonActionPerformed
        resetFields();
    }//GEN-LAST:event_ResetButtonActionPerformed

    private void ConvertButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ConvertButtonActionPerformed
        convertValues();
    }//GEN-LAST:event_ConvertButtonActionPerformed
       

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel ControlPanel;
    private javax.swing.JButton ConvertButton;
    private javax.swing.JButton ResetButton;
    private javax.swing.JComboBox<String> SourceCurrencyCombobox;
    private javax.swing.JPanel SourcePanel;
    private javax.swing.JLabel SourceValueLabel;
    private javax.swing.JTextField SourceValueTexfield;
    private javax.swing.JComboBox<String> TargetCurrencyCombobox;
    private javax.swing.JPanel TargetPanel;
    private javax.swing.JLabel TargetValueLabel;
    private javax.swing.JTextField TargetValueTexfield;
    // End of variables declaration//GEN-END:variables

    private void getInitialListing() {
        listing = (RateListing) ObjectSerializer.deserializeObject("initialRateListing.erf");        
    }
    
    private void resetFields() {
        SourceValueTexfield.setText("");
        SourceCurrencyCombobox.setSelectedIndex(0);
        TargetValueTexfield.setText("");
        TargetCurrencyCombobox.setSelectedIndex(0);
    }

    private void setComboboxModels() {
       DefaultComboBoxModel model = createComboboxModel();
       DefaultComboBoxModel model2 = createComboboxModel();
       SourceCurrencyCombobox.setModel(model);
       TargetCurrencyCombobox.setModel(model2);
    }

    private DefaultComboBoxModel createComboboxModel() {
        ArrayList<String> currencyNames = new ArrayList<>();
        
        for(ExchangeRate rate : listing) {
            currencyNames.add(rate.getName());
        }
        currencyNames.add(listing.getBaseCurrency());
        
        sortNames(currencyNames);
        
        DefaultComboBoxModel model = new DefaultComboBoxModel(currencyNames.toArray());
        return model;
    }    

    private void sortNames(ArrayList<String> currencyNames) {
        Collections.sort(currencyNames, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }            
        });
    }

    private void convertValues() {
        double SourceRateInEur = getSourceRateInEur();
        double TargetRateInEur = getTargetRateInEur();
        double SourceValue = parseSourceValue();
        double TargetValue = 0;
        
        TargetValue = (TargetRateInEur * SourceValue) / SourceRateInEur;
        TargetValue = Math.round(TargetValue * 100.00) / 100.00;
        TargetValueTexfield.setText(String.valueOf(TargetValue));
    }

    private double getSourceRateInEur() {
        String SourceUnit = SourceCurrencyCombobox.getSelectedItem().toString();
        
        for(ExchangeRate rate : listing) {
            if(SourceUnit.equals("EUR")) {
                return 1;
            } else if(SourceUnit.equals(rate.getName())) {
                return rate.getValue();
            }
        }   
        return 0;
    }

    private double getTargetRateInEur() {
        String TargetUnit = TargetCurrencyCombobox.getSelectedItem().toString();
        
        for(ExchangeRate rate : listing) {
            if(TargetUnit.equals(rate.getName())) {
                return rate.getValue();
            }
        }
        return 0;
    }
    
    private double parseSourceValue() {
        String SourceValueString = SourceValueTexfield.getText();
        
        try {
            double SourceValue = Double.parseDouble(SourceValueString);
            return SourceValue;
        } catch(NumberFormatException | NullPointerException ex) {
            return 0;
        }
    }        
}
