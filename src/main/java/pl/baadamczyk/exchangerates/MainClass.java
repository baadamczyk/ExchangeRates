package pl.baadamczyk.exchangerates;

import java.util.ArrayList;
import pl.baadamczyk.exchangerates.dataprocessing.xmlentities.DataSource;
import pl.baadamczyk.exchangerates.dataprocessing.SourcesManager;
import pl.baadamczyk.exchangerates.ui.LoadingDialog;

/*
 * @author baadamczyk
 */
public class MainClass {
    
    public static void main(String[] args) {
//        displayLoadingScreen();
          SourcesManager sourceHandler = new SourcesManager();
          ArrayList<DataSource>  slist = sourceHandler.getSourceList();
          System.out.println("DONE");
    }

    private static void displayLoadingScreen() {
        LoadingDialog loadingDialog = new LoadingDialog();
        loadingDialog.setVisible(true);         
    }
}
