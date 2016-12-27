package pl.baadamczyk.exchangerates;

import pl.baadamczyk.exchangerates.ui.LoadingDialog;

/*
 * @author baadamczyk
 */
public class MainClass {
    
    public static void main(String[] args) {
        displayLoadingScreen();
    }

    private static void displayLoadingScreen() {
        LoadingDialog loadingDialog = new LoadingDialog();
        loadingDialog.setVisible(true);
    }
}
