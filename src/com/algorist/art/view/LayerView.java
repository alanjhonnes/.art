/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.algorist.art.view;

import com.alanjhonnes.event.CallbackFunction;
import com.alanjhonnes.event.Event;
import com.algorist.art.event.LayerEvent;
import com.algorist.art.model.Layer;
import javax.swing.JPanel;
import mvc.AbstractFrame;
import mvc.AbstractView;

/**
 *
 * @author user
 */
public class LayerView extends AbstractView<JPanel>{
    
    private Layer model;

    public LayerView(AbstractFrame mainFrame, Layer layerModel) {
        super(mainFrame);
        this.model = layerModel;
        model.addEventListener(LayerEvent.OPACITY_CHANGED, new CallbackFunction() {

            @Override
            public void execute(Event e) {
                //TODO
            }
        });
    }

    @Override
    protected JPanel layout() {
        JPanel panel = new JPanel();
        return panel;
    }
    
}
