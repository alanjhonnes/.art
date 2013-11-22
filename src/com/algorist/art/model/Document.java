/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.algorist.art.model;

import com.alanjhonnes.event.EventDispatcher;
import com.algorist.art.event.DocumentEvent;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Represents an opened file
 * @author alan.jbssa
 */
public class Document extends EventDispatcher implements Serializable {
    private List<Layer> layers;
    private List<State> states;
    private int width;
    private int height;
    private Layer selectedLayer;
    private String name;

    public Document(String name, int width, int height) {
        this.name = name;
        this.width = width;
        this.height = height;
        layers = new ArrayList<>();
        states = new LinkedList<>();
        selectedLayer = new Layer(width, height);
        layers.add(selectedLayer);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
        dispatchEvent(new DocumentEvent(this, DocumentEvent.LAYER_SELECTED, selectedLayer));
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
    
    public Document getSerializableVersion(){
        Document doc = new Document(this.name,this.width,this.height);
        List<Layer> docLayers = new ArrayList<>();
        Layer layer = null;
        for (int i = 0; i < layers.size(); i++) {
            layer = layers.get(i);
            layer = layer.duplicate();
            docLayers.add(layer);
        }
        doc.setLayers(docLayers);
        doc.setSelectedLayer(layer);
        return doc;
    }

    public void addLayer() {
        Layer layer = new Layer(width, height);
        layers.add(layer);
        dispatchEvent(new DocumentEvent(this, DocumentEvent.LAYER_ADDED, layer));
    }

    public BufferedImage getResultingImage() {
        return selectedLayer.getImage();
    }

    public void setSize(int width, int height) {
        for (int i = 0; i < layers.size(); i++) {
            Layer layer = layers.get(i);
            layer.setSize(width, height);
        }
        dispatchEvent(new DocumentEvent(this, DocumentEvent.SIZE_CHANGED));
    }
    
    
    
}
