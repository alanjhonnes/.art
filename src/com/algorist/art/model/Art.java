/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.algorist.art.model;

import com.algorist.art.model.brushes.Brush;
import java.util.Observable;

/**
 * Model class for each document 
 * @author senac2012
 */
public class Art extends Observable {
    
    private State currentState;
    
    private Layer selectedLayer;
    
    private History history;
    
    private Layers layers;
    
    private int width;
    private int height;
    
    private Brush selectedBrush;
    

    public Art() {
        layers = new Layers();
        layers.addLayer();
    }
    
    public void saveState(){
        
    }
    
    
    
}
