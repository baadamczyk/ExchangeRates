package pl.baadamczyk.exchangerates.ui;

import java.awt.Dimension;
import javax.swing.JFrame;
import pl.baadamczyk.exchangerates.dataprocessing.RateListing;

/**
 * @author baadamczyk
 */
public abstract class Window extends JFrame {
    
    public Window(int width, int height, String title) {
        setWindowProperties(width, height, title);
    }
    
    public void refreshData(RateListing listing) {
        LoadingDialog dialog;
        
        if(listing == null) dialog = new LoadingDialog();
        else dialog = new LoadingDialog(listing);
        
        dialog.setVisible(true);
        this.dispose();
    }
    
    public void setWindowProperties(int width, int height, String title) {
        setWindowTitle(title);
        setWindowSize(new Dimension(width, height));
        centerWindow();        
    }
    
    private void setWindowTitle(String title) {
        this.setTitle(title);
    }

    private void setWindowSize(Dimension WindowSize) {
        setPreferredSize(WindowSize);
        setMaximumSize(this.getPreferredSize());
        setMinimumSize(this.getPreferredSize());
        setResizable(false);        
    }

    private void centerWindow() {
        setLocationRelativeTo(null);
    }
    
    
}
