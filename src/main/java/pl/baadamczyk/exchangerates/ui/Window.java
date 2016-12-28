package pl.baadamczyk.exchangerates.ui;

import java.awt.Dimension;
import javax.swing.JFrame;

/**
 * @author baadamczyk
 */
public abstract class Window extends JFrame {
    
    public Window(int width, int height, String title) {
        setWindowProperties(width, height, title);
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
