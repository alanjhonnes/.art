/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.algorist.art.model;

import java.util.Iterator;
import java.util.List;
import java.util.Observable;


/**
 *
 * @author senac2012
 */
public class Layers extends Observable {
    private List<Layer> layers;

    public List<Layer> getLayers() {
        return layers;
    }

    public void setLayers(List<Layer> layers) {
        this.layers = layers;
    }
    
    public void addLayer(){
        //layers.add(new Layer();
        notifyObservers(this);
    }
    
    public void deleteLayer(Layer layer){
        for (Iterator<Layer> it = layers.iterator(); it.hasNext();) {
            if(it.next() == layer){
                it.remove();
                notifyObservers(this);
                break;
            }
        }
    }
    
    
}
