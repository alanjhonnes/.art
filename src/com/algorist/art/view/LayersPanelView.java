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
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
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
        
        model.addEventListener(DocumentEvent.LAYER_ADDED, new CallbackFunction() {
            @Override
            public void execute(Event e) {
                DocumentEvent de = (DocumentEvent) e;
                LayerPanelView layerPanelView = new LayerPanelView(getMainFrame(), de.getLayer());
                layerViews.add(layerPanelView);
                contentPane.add(layerPanelView.getContentPane());
                contentPane.revalidate();
            }
        });
        
        model.addEventListener(DocumentEvent.LAYER_REMOVED, new CallbackFunction() {
            @Override
            public void execute(Event e) {
                
            }
        });
        
        model.addEventListener(DocumentEvent.LAYER_SELECTED, new CallbackFunction() {
            @Override
            public void execute(Event e) {
                
            }
        });
        
        model.addEventListener(DocumentEvent.LAYERS_ORDER_CHANGED, new CallbackFunction() {
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
