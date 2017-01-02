package pl.baadamczyk.exchangerates;

import pl.baadamczyk.exchangerates.dataprocessing.DataDownloader;
import pl.baadamczyk.exchangerates.dataprocessing.RateListing;
import pl.baadamczyk.exchangerates.ui.LoadingDialog;

/*
 * @author baadamczyk
 */
public class MainClass {
    
    public static void main(String[] args) {
//        displayLoadingScreen();
        DataDownloader downloader = new DataDownloader();
        RateListing listing = downloader.getRateListing();        
    }

    private static void displayLoadingScreen() {
        LoadingDialog loadingDialog = new LoadingDialog();
        loadingDialog.setVisible(true);         
    }
}
