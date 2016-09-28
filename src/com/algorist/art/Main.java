/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.algorist.art;

import com.algorist.art.util.FileManager;
import com.algorist.art.view.MainFrame;

/**
 *
 * @author alan.jbssa 
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ModelAcessor modelAcessor = new ModelAcessor();
                modelAcessor.initializeModel();
                FileManager.initialize();
                MainFrame mainFrame = new MainFrame(modelAcessor);
                mainFrame.show();
            }
        });

    }
}
