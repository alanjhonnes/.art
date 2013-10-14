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

    public State getCurrentState() {
        return currentState;
    }

    public void setCurrentState(State currentState) {
        this.currentState = currentState;
    }

    public Layer getSelectedLayer() {
        return selectedLayer;
    }

    public void setSelectedLayer(Layer selectedLayer) {
        this.selectedLayer = selectedLayer;
    }

    public History getHistory() {
        return history;
    }

    public void setHistory(History history) {
        this.history = history;
    }

    public Layers getLayers() {
        return layers;
    }

    public void setLayers(Layers layers) {
        this.layers = layers;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public Brush getSelectedBrush() {
        return selectedBrush;
    }

    public void setSelectedBrush(Brush selectedBrush) {
        this.selectedBrush = selectedBrush;
    }
    
    
    
    
    
}
