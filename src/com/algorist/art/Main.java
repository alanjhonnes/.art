/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.algorist.art;

import com.alanjhonnes.event.CallbackFunction;
import com.alanjhonnes.event.Event;
import com.algorist.art.controller.LayerController;
import com.algorist.art.event.LayerEvent;
import com.algorist.art.model.Layer;
import com.algorist.art.view.MainFrame;
import com.algorist.art.view.MainView;
import java.util.Collections;

/**
 *
 * @author alan.jbssa
 */
public class Main {

    public static MainView nav;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ModelAcessor modelAcessor = new ModelAcessor();
                modelAcessor.initializeModel();
                MainFrame mainFrame = new MainFrame(modelAcessor);
                mainFrame.show();
            }
        });

    }
    
    
    
}
