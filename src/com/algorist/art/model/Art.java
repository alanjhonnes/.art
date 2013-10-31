/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.algorist.art.model;

import com.alanjhonnes.event.EventDispatcher;
import com.algorist.art.event.ArtEvent;
import com.algorist.art.model.brushes.Brush;
import java.util.ArrayList;
import java.util.List;

/**
 * Main model class, contains the whole list of openned documents. 
 * @author senac2012
 */
public class Art extends EventDispatcher {
    
    private Brush selectedBrush;
    private List<Document> documents;
    private Document currentDocument;
    private List<Movement> movements;

    public Art() {
        documents = new ArrayList<>();
    }
    
    public void addDocument(Document document){
        documents.add(document);
        dispatchEvent(new ArtEvent(document, ArtEvent.DOCUMENT_ADDED, document));
    }
    
    public void removeDocument(Document document){
        documents.remove(document);
        dispatchEvent(new ArtEvent(document, ArtEvent.DOCUMENT_REMOVED, document));
    }
    
    public void startMovement(Movement movement){
        movements.add(movement);
        dispatchEvent(new ArtEvent(this, ArtEvent.MOVEMENT_STARTED, movement));
    }
    
    public void endMovement(Movement movement){
        movements.remove(movement);
        dispatchEvent(new ArtEvent(this, ArtEvent.MOVEMENT_ENDED, movement));
    }
    

    public Brush getSelectedBrush() {
        return selectedBrush;
    }

    public void setSelectedBrush(Brush selectedBrush) {
        this.selectedBrush = selectedBrush;
        dispatchEvent(new ArtEvent(this, ArtEvent.BRUSH_CHANGED, selectedBrush));
    }
    
    public Document getCurrentDocument() {
        return currentDocument;
    }

    public void setCurrentDocument(Document currentDocument) {
        this.currentDocument = currentDocument;
        dispatchEvent(new ArtEvent(this, ArtEvent.DOCUMENT_CHANGED, currentDocument));
    }

    public List<Document> getDocuments() {
        return documents;
    }

    public void setDocuments(List<Document> documents) {
        this.documents = documents;
    }

    public List<Movement> getMovements() {
        return movements;
    }

    public void setMovements(List<Movement> movements) {
        this.movements = movements;
    }
    
    
    
}
