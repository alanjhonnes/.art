/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.algorist.art.view;

import com.algorist.art.model.Document;
import com.algorist.art.model.Layers;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JPanel;
import mvc.AbstractFrame;
import mvc.AbstractView;

/**
 *
 * @author senac2012
 */
public class LayersPanelView extends AbstractView<JPanel> implements Observer {

    private Document model;
    
    public LayersPanelView(AbstractFrame mainFrame, Document documentModel) {
        super(mainFrame);
        this.model = documentModel;
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
