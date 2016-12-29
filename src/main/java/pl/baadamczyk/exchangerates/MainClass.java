package pl.baadamczyk.exchangerates;

import pl.baadamczyk.exchangerates.ui.LoadingDialog;
import pl.baadamczyk.exchangerates.ui.MainWindow;

/*
 * @author baadamczyk
 */
public class MainClass {
    
    public static void main(String[] args) {
        displayLoadingScreen();
    }

    private static void displayLoadingScreen() {
//        LoadingDialog loadingDialog = new LoadingDialog();
//        loadingDialog.setVisible(true);

        MainWindow mainWindow = new MainWindow();
        mainWindow.setVisible(true);           
    }
}
