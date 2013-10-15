/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.algorist.art.model;

import java.util.List;
import java.util.Observable;

/**
 * Holds the list of open documents
 * @author alan.jbssa
 */
public class Documents extends Observable {
    private List<Document> documents;
    
    public void addDocument(Document document){
        documents.add(document);
        notifyObservers();
    }
    
    public void removeDocument(Document document){
        documents.remove(document);
        notifyObservers();
    }

    public List<Document> getDocuments() {
        return documents;
    }
    
    public void setDocuments(List<Document> documents) {
        this.documents = documents;
        notifyObservers();
    }
    
    
}
