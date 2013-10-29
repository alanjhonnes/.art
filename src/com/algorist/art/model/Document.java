/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.algorist.art.model;

import com.alanjhonnes.event.EventDispatcher;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Observable;

/**
 * Represents an opened file
 * @author alan.jbssa
 */
public class Document extends EventDispatcher {
    private List<Layer> layers;
    private List<State> states;
    private int width;
    private int height;
    private Layer selectedLayer;

    public Document(int width, int height) {
        this.width = width;
        this.height = height;
        layers = new ArrayList<>();
        states = new LinkedList<>();
        selectedLayer = new Layer(width, height);
        layers.add(selectedLayer);
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

    public Layer getSelectedLayer() {
        return selectedLayer;
    }

    public void setSelectedLayer(Layer selectedLayer) {
        this.selectedLayer = selectedLayer;
    }

    public List<Layer> getLayers() {
        return layers;
    }

    public void setLayers(List<Layer> layers) {
        this.layers = layers;
    }

    public List<State> getStates() {
        return states;
    }

    public void setStates(List<State> states) {
        this.states = states;
    }
    
    
    
}
