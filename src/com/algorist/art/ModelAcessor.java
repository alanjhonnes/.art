/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.algorist.art;

import com.algorist.art.model.Art;
import com.algorist.art.model.Document;
import com.algorist.art.model.History;
import com.algorist.art.model.Layers;
import com.algorist.art.model.Preferences;

/**
 * 
 * @author alan.jbssa
 */
public class ModelAcessor {
    
    private Preferences preferences;
    private History history;
    private Layers layers;
    private Art art;

    //TODO
    public ModelAcessor() {
        
        
    }
    
    public void initializeModel(){
        art = new Art();
        Document doc = new Document(600, 500);
        art.getDocuments().add(doc);
        art.setCurrentDocument(doc);
    }

    public Preferences getPreferences() {
        return preferences;
    }

    public void setPreferences(Preferences preferences) {
        this.preferences = preferences;
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

    public Art getArt() {
        return art;
    }

    public void setArt(Art art) {
        this.art = art;
    }
    
    
    
    
    
    
}
