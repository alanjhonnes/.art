/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.algorist.art.view;

import com.algorist.art.model.Layer;
import javax.swing.JPanel;
import mvc.AbstractFrame;
import mvc.AbstractView;

/**
 *
 * @author senac2012
 */
public class LayerPanelView extends AbstractView<JPanel> {

    private Layer model;
    
    public LayerPanelView(AbstractFrame mainFrame, Layer layerModel) {
        super(mainFrame);
        this.model = layerModel;
    }

    
    
    @Override
    protected JPanel layout() {
        
        
        
    }
    
}
