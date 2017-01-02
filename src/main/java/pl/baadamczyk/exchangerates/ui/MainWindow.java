/* @author baadamczyk */

package pl.baadamczyk.exchangerates.ui;

import java.awt.GridLayout;
import pl.baadamczyk.exchangerates.dataprocessing.RateListing;
import pl.baadamczyk.exchangerates.dataprocessing.xmlentities.ExchangeRate;

public class MainWindow extends Window {
    
    private String ActiveCurrencySymbol = "CURR_SYMB";
 
    public MainWindow(RateListing listing) {
        super(600, 500, "ExchangeRates");
        initComponents();
        inputDataFromListing(listing);
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
        PayPalPaymentsMenuOption = new javax.swing.JMenuItem();
        PreferencesSubmenu = new javax.swing.JMenu();
        ChangeBaseCurrMenuOption = new javax.swing.JMenuItem();
        DataSourceSelectionMenuOption = new javax.swing.JMenuItem();
        HelpSubmenu = new javax.swing.JMenu();
        IntroductionMenuOption = new javax.swing.JMenuItem();
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

        RefreshMenuOption.setText("Refresh");
        ApplicationSubmenu.add(RefreshMenuOption);

        ExitMenuOption.setText("Exit");
        ApplicationSubmenu.add(ExitMenuOption);

        ApplicationMenu.add(ApplicationSubmenu);

        ToolSubmenu.setText("Tools");

        ConverterMenuOption.setText("Rates converter");
        ConverterMenuOption.setActionCommand("Rates converter");
        ToolSubmenu.add(ConverterMenuOption);

        PayPalPaymentsMenuOption.setText("PayPal payments calculator");
        ToolSubmenu.add(PayPalPaymentsMenuOption);

        ApplicationMenu.add(ToolSubmenu);

        PreferencesSubmenu.setText("Preferences");

        ChangeBaseCurrMenuOption.setText("Change base currency");
        PreferencesSubmenu.add(ChangeBaseCurrMenuOption);

        DataSourceSelectionMenuOption.setText("Change data source");
        PreferencesSubmenu.add(DataSourceSelectionMenuOption);

        ApplicationMenu.add(PreferencesSubmenu);

        HelpSubmenu.setText("Help");
        HelpSubmenu.setActionCommand("");

        IntroductionMenuOption.setText("Introduction");
        HelpSubmenu.add(IntroductionMenuOption);

        AboutMenuOption.setText("About");
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
            .addGap(0, 579, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 567, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
          

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem AboutMenuOption;
    private javax.swing.JMenuBar ApplicationMenu;
    private javax.swing.JMenu ApplicationSubmenu;
    private javax.swing.JMenuItem ChangeBaseCurrMenuOption;
    private javax.swing.JMenuItem ConverterMenuOption;
    private javax.swing.JMenuItem DataSourceSelectionMenuOption;
    private javax.swing.JMenuItem ExitMenuOption;
    private javax.swing.JMenu HelpSubmenu;
    private javax.swing.JMenuItem IntroductionMenuOption;
    private javax.swing.JMenuItem PayPalPaymentsMenuOption;
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
            RateDisplayContainer.add(new EntryTile(rate.getName(), rate.getValue()));
        }
    }
}
