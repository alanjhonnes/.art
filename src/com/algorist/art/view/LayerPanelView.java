/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.algorist.art.view;

import java.util.Observable;
import java.util.Observer;
import javax.swing.JPanel;
import mvc.AbstractFrame;
import mvc.AbstractView;

/**
 *
 * @author senac2012
 */
public class LayerPanelView extends AbstractView<JPanel> implements Observer {

    public LayerPanelView(AbstractFrame mainFrame) {
        super(mainFrame);
    }

    @Override
    protected JPanel layout() {
        JPanel panel = new JPanel();
        
        return panel;
    }

    @Override
    public void update(Observable o, Object o1) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
