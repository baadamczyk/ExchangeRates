/* @author baadamczyk */

package pl.baadamczyk.exchangerates.ui;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.InputStream;
import java.util.zip.InflaterInputStream;
import pl.baadamczyk.exchangerates.dataprocessing.RateListing;
import pl.baadamczyk.exchangerates.dataprocessing.xmlentities.ExchangeRate;

public class MainWindow extends Window implements ActionListener {
    
    private String ActiveCurrencySymbol = "CURR_SYMB";
    private RateListing rateListing;
    private RateListing eurRateListing;
 
    public MainWindow(RateListing listing) {
        super(600, 500, "ExchangeRates");
        initComponents();
        
        rateListing = listing;
        inputDataFromListing(rateListing);
        appendCurrencySymbolToWindowTitle();
        setContainerLayout();        
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jMenuItem1 = new javax.swing.JMenuItem();
        jScrollPane1 = new javax.swing.JScrollPane();
        RateDisplayContainer = new javax.swing.JPanel();
        ApplicationMenu = new javax.swing.JMenuBar();
        ApplicationSubmenu = new javax.swing.JMenu();
        RefreshMenuOption = new javax.swing.JMenuItem();
        ExitMenuOption = new javax.swing.JMenuItem();
        ToolSubmenu = new javax.swing.JMenu();
        ConverterMenuOption = new javax.swing.JMenuItem();
        PreferencesSubmenu = new javax.swing.JMenu();
        ChangeBaseCurrMenuOption = new javax.swing.JMenuItem();
        HelpSubmenu = new javax.swing.JMenu();
        AboutMenuOption = new javax.swing.JMenuItem();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jMenuItem1.setText("jMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        RateDisplayContainer.setMinimumSize(getPreferredSize());
        RateDisplayContainer.setPreferredSize(new java.awt.Dimension(550, 550));

        javax.swing.GroupLayout RateDisplayContainerLayout = new javax.swing.GroupLayout(RateDisplayContainer);
        RateDisplayContainer.setLayout(RateDisplayContainerLayout);
        RateDisplayContainerLayout.setHorizontalGroup(
            RateDisplayContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 612, Short.MAX_VALUE)
        );
        RateDisplayContainerLayout.setVerticalGroup(
            RateDisplayContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jScrollPane1.setViewportView(RateDisplayContainer);

        ApplicationSubmenu.setText("Application");

        RefreshMenuOption.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F5, 0));
        RefreshMenuOption.setText("Refresh");
        RefreshMenuOption.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RefreshMenuOptionActionPerformed(evt);
            }
        });
        ApplicationSubmenu.add(RefreshMenuOption);

        ExitMenuOption.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F4, java.awt.event.InputEvent.ALT_MASK));
        ExitMenuOption.setText("Exit");
        ExitMenuOption.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExitMenuOptionActionPerformed(evt);
            }
        });
        ApplicationSubmenu.add(ExitMenuOption);

        ApplicationMenu.add(ApplicationSubmenu);

        ToolSubmenu.setText("Tools");

        ConverterMenuOption.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F8, 0));
        ConverterMenuOption.setText("Rates converter");
        ConverterMenuOption.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ConverterMenuOptionActionPerformed(evt);
            }
        });
        ToolSubmenu.add(ConverterMenuOption);

        ApplicationMenu.add(ToolSubmenu);

        PreferencesSubmenu.setText("Preferences");

        ChangeBaseCurrMenuOption.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        ChangeBaseCurrMenuOption.setText("Change base currency");
        ChangeBaseCurrMenuOption.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ChangeBaseCurrMenuOptionActionPerformed(evt);
            }
        });
        PreferencesSubmenu.add(ChangeBaseCurrMenuOption);

        ApplicationMenu.add(PreferencesSubmenu);

        HelpSubmenu.setText("Help");
        HelpSubmenu.setActionCommand("");

        AboutMenuOption.setText("About");
        AboutMenuOption.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AboutMenuOptionActionPerformed(evt);
            }
        });
        HelpSubmenu.add(AboutMenuOption);

        ApplicationMenu.add(HelpSubmenu);

        setJMenuBar(ApplicationMenu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 612, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 581, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 569, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void RefreshMenuOptionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RefreshMenuOptionActionPerformed
        refreshData(null);
    }//GEN-LAST:event_RefreshMenuOptionActionPerformed

    private void ExitMenuOptionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExitMenuOptionActionPerformed
        System.exit(0);
    }//GEN-LAST:event_ExitMenuOptionActionPerformed

    private void ChangeBaseCurrMenuOptionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ChangeBaseCurrMenuOptionActionPerformed
        changeBaseCurrency();
    }//GEN-LAST:event_ChangeBaseCurrMenuOptionActionPerformed

    private void ConverterMenuOptionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ConverterMenuOptionActionPerformed
        CurrencyConverter converter = new CurrencyConverter();
        converter.setVisible(true);
    }//GEN-LAST:event_ConverterMenuOptionActionPerformed

    private void AboutMenuOptionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AboutMenuOptionActionPerformed
        AboutWindow aboutWindow = new AboutWindow();
        aboutWindow.setVisible(true);
    }//GEN-LAST:event_AboutMenuOptionActionPerformed
          

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem AboutMenuOption;
    private javax.swing.JMenuBar ApplicationMenu;
    private javax.swing.JMenu ApplicationSubmenu;
    private javax.swing.JMenuItem ChangeBaseCurrMenuOption;
    private javax.swing.JMenuItem ConverterMenuOption;
    private javax.swing.JMenuItem ExitMenuOption;
    private javax.swing.JMenu HelpSubmenu;
    private javax.swing.JMenu PreferencesSubmenu;
    private javax.swing.JPanel RateDisplayContainer;
    private javax.swing.JMenuItem RefreshMenuOption;
    private javax.swing.JMenu ToolSubmenu;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

    private void appendCurrencySymbolToWindowTitle() {
        this.setTitle(this.getTitle()+"   -   ["+ActiveCurrencySymbol+"]");        
    }

    private void setContainerLayout() {
        RateDisplayContainer.setLayout(new GridLayout(0, 3));                        
    }

    private void inputDataFromListing(RateListing listing) {
        ActiveCurrencySymbol = listing.getBaseCurrency();
        
        for(ExchangeRate rate : listing) {
            RateDisplayContainer.add(new EntryTile(rate.getName(), String.valueOf(rate.getValue())));
        }
    }

    private void changeBaseCurrency() {        
        CurrencySelectionDialog selectionDialog = new CurrencySelectionDialog(rateListing, this);
        selectionDialog.setVisible(true);        
    }     

    @Override
    public void actionPerformed(ActionEvent e) {
        this.dispose();
    }    
}
