/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.algorist.art.controller;

import com.alanjhonnes.event.CallbackFunction;
import com.alanjhonnes.event.Event;
import com.algorist.art.event.LayerEvent;
import com.algorist.art.model.Layer;
import mvc.AbstractController;
import mvc.AbstractFrame;

/**
 *
 * @author alan.jbssa
 */
public class LayerController extends AbstractController {
    
    private Layer layer;
    
    public LayerController(AbstractFrame mainFrame, Layer layer) {
        super(mainFrame);
        this.layer = layer;
        
    }
    
}
