package pl.baadamczyk.exchangerates;

import pl.baadamczyk.exchangerates.dataprocessing.DataDownloader;
import pl.baadamczyk.exchangerates.dataprocessing.RateListing;
import pl.baadamczyk.exchangerates.ui.LoadingDialog;
import pl.baadamczyk.exchangerates.ui.MainWindow;

/*
 * @author baadamczyk
 */
public class MainClass {
    
    public static void main(String[] args) {
//        displayLoadingScreen();
        DataDownloader downloader = new DataDownloader();
        RateListing listing = downloader.getRateListing();
        MainWindow window = new MainWindow(listing);
        window.setVisible(true);
    }

    private static void displayLoadingScreen() {
        LoadingDialog loadingDialog = new LoadingDialog();
        loadingDialog.setVisible(true);         
    }
}
