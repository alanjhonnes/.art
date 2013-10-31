/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.algorist.art.view;

import com.alanjhonnes.event.CallbackFunction;
import com.alanjhonnes.event.Event;
import com.algorist.art.event.DocumentEvent;
import com.algorist.art.model.Document;
import com.algorist.art.model.Layer;
import com.algorist.art.model.Layers;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JPanel;
import mvc.AbstractFrame;
import mvc.AbstractView;

/**
 *
 * @author alanjhonnes
 */
public class LayersPanelView extends AbstractView<JPanel> {
    private List<LayerPanelView> layerViews;
    private Document model;

    public LayersPanelView(AbstractFrame mainFrame, Document documentModel) {
        
        super(mainFrame);
        layerViews = new ArrayList<>();
        this.model = documentModel;
        setupLayers();
        model.addEventListener(DocumentEvent.LAYERS_CHANGED, new CallbackFunction() {
            @Override
            public void execute(Event e) {
                
            }
        });
    }

    @Override
    protected JPanel layout() {
        JPanel panel = new JPanel();
        
        return panel;
    }

    private void setupLayers() {
        List<Layer> layers = model.getLayers();
        for (Iterator<Layer> it = layers.iterator(); it.hasNext();) {
            Layer layer = it.next();
            LayerPanelView layerView = new LayerPanelView(getMainFrame(), layer);
            layerViews.add(layerView);
            contentPane.add(layerView.getContentPane());
            
        }
    }
}
