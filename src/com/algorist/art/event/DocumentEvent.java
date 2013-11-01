/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.algorist.art.event;

import com.alanjhonnes.event.Event;
import com.alanjhonnes.event.IEventDispatcher;
import com.algorist.art.model.Layer;

/**
 *
 * @author user
 */
public class DocumentEvent extends Event {
    
    public static final String SIZE_CHANGED = "sizeChanged";
    public static final String LAYERS_ORDER_CHANGED = "layersOrderChanged";
    public static final String LAYER_ADDED = "layerAdded";
    public static final String LAYER_REMOVED = "layerRemoved";
    public static final String LAYER_SELECTED = "layerSelected";
    
    private Layer layer;
    
    public DocumentEvent(IEventDispatcher source, String type) {
        super(source, type);
    }
    
    public DocumentEvent(IEventDispatcher source, String type, Layer layer) {
        super(source, type);
        this.layer = layer;
    }

    public Layer getLayer() {
        return layer;
    }

    public void setLayer(Layer layer) {
        this.layer = layer;
    }
    
}
