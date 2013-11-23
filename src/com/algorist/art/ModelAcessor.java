/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.algorist.art;

import com.algorist.art.model.Art;
import com.algorist.art.model.Document;
import com.algorist.art.model.History;

/**
 * 
 * @author alan.jbssa
 */
public class ModelAcessor {
    
    private History history;
    private Art art;

    //TODO
    public ModelAcessor() {
        
        
    }
    
    public void initializeModel(){
        art = new Art();
        Document doc = new Document("Novo documento", 600, 500);
        art.getDocuments().add(doc);
        art.setCurrentDocument(doc);
    }

    public History getHistory() {
        return history;
    }

    public void setHistory(History history) {
        this.history = history;
    }

    public Art getArt() {
        return art;
    }

    public void setArt(Art art) {
        this.art = art;
    }
    
    
    
    
    
    
}
