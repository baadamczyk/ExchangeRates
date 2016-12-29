package pl.baadamczyk.exchangerates.ui;

import javax.swing.JOptionPane;

/**
 *
 * @author baadamczyk
 */
public class LoadingDialog extends Window {

    public LoadingDialog() {
        super(500, 150, "Loading data ...");        
        initComponents();       
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel1 = new javax.swing.JPanel();
        ActionDescriptionLabel = new javax.swing.JLabel();
        CancelButton = new javax.swing.JButton();
        LoadingIconImage = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setAlwaysOnTop(true);
        setMaximumSize(new java.awt.Dimension(800, 150));
        setMinimumSize(getPreferredSize());
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                onWindowOpened(evt);
            }
        });

        jPanel1.setLayout(new java.awt.GridBagLayout());

        ActionDescriptionLabel.setText("This is sample pending action description . . .");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.insets = new java.awt.Insets(9, 0, 0, 0);
        jPanel1.add(ActionDescriptionLabel, gridBagConstraints);

        CancelButton.setText("Cancel");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.insets = new java.awt.Insets(14, 0, 12, 0);
        jPanel1.add(CancelButton, gridBagConstraints);

        LoadingIconImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/graphics/loadingicon.gif"))); // NOI18N
        LoadingIconImage.setToolTipText("");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 20);
        jPanel1.add(LoadingIconImage, gridBagConstraints);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 488, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void onWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_onWindowOpened
        try {
            getRawData();
        } catch (Exception e) {
            handleLoadingException();
        }
    }//GEN-LAST:event_onWindowOpened

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel ActionDescriptionLabel;
    private javax.swing.JButton CancelButton;
    private javax.swing.JLabel LoadingIconImage;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables

    private void getRawData() {
    }

    private void handleLoadingException() {
        JOptionPane.showMessageDialog(this, "A loading error has occured. "
                    + "Application will be closed. Please try again later ...", "Loading error", JOptionPane.ERROR_MESSAGE);
        System.exit(1);
    }
}
