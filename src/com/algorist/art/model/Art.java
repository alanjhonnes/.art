/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.algorist.art.model;

import com.alanjhonnes.event.EventDispatcher;
import com.algorist.art.event.ArtEvent;
import com.algorist.art.model.brushes.Brush;
import com.algorist.art.model.brushes.CirclesBrush;
import com.algorist.art.model.brushes.LinesBrush;
import com.algorist.art.model.brushes.NeonParticles;
import com.algorist.art.model.brushes.PhynnaBrush;
import com.algorist.art.model.brushes.AlchemyBrush;
import com.algorist.art.model.brushes.Vintage;
import com.algorist.art.model.brushes.SprayHardcoreBrush;
import com.algorist.art.model.brushes.SilkBrush;
import java.util.ArrayList;
import java.util.List;

/**
 * Main model class, contains the whole list of open documents, brushes and 
 * active movements. 
 * @author alanjhonnes
 */
public class Art extends EventDispatcher {
    
    private Brush selectedBrush;
    private List<Document> documents;
    private Document currentDocument;
    private List<Movement> movements;
    private List<Brush> brushes;

    public Art() {
        documents = new ArrayList<>();
        movements = new ArrayList<>();
        brushes = new ArrayList<>();
        brushes.add(new SilkBrush());
        brushes.add(new NeonParticles());
        brushes.add(new CirclesBrush());
        brushes.add(new LinesBrush());
        brushes.add(new PhynnaBrush());
        brushes.add(new AlchemyBrush());
        brushes.add(new Vintage());
        brushes.add(new SprayHardcoreBrush());
           
        
        setSelectedBrush(brushes.get(0));
    }
    
    /**
     * Adds a document to the list of documents and dispatches a DOCUMENT_ADDED
     * event.
     * @param document 
     */
    public void addDocument(Document document){
        documents.add(document);
        dispatchEvent(new ArtEvent(document, ArtEvent.DOCUMENT_ADDED, document));
    }
    
    /**
    * Removes a document to the list of documents and dispatches a 
    * DOCUMENT_REMOVED event.
    * @param document 
    */
    public void removeDocument(Document document){
        documents.remove(document);
        dispatchEvent(new ArtEvent(document, ArtEvent.DOCUMENT_REMOVED, document));
        document.dispose();
    }
    
    /**
     * Adds a new movement to the list and dispatches a MOVEMENT_STARTED event
     * @param movement 
     */
    public void startMovement(Movement movement){
        movements.add(movement);
        dispatchEvent(new ArtEvent(this, ArtEvent.MOVEMENT_STARTED, movement));
    }
    
    /**
     * Removes and stops a movement, dispatching a MOVEMENT_ENDED event.
     * @param movement 
     */
    public void endMovement(Movement movement){
        movements.remove(movement);
        dispatchEvent(new ArtEvent(this, ArtEvent.MOVEMENT_ENDED, movement));
        movement.stop();
    }
    

    public Brush getSelectedBrush() {
        return selectedBrush;
    }

    /**
     * Sets the selected brush and dispatches a BRUSH_CHANGED event.
     * @param selectedBrush 
     */
    public void setSelectedBrush(Brush selectedBrush) {
        this.selectedBrush = selectedBrush;
        dispatchEvent(new ArtEvent(this, ArtEvent.BRUSH_CHANGED, selectedBrush));
    }
    
    public Document getCurrentDocument() {
        return currentDocument;
    }

    /**
     * Sets the current document, initialize the selected brush with the new 
     * dimensions and dispatches a DOCUMENT_CHANGED event.
     * @param currentDocument 
     */
    public void setCurrentDocument(Document currentDocument) {
        this.currentDocument = currentDocument;
        selectedBrush.initialize(currentDocument.getWidth(), currentDocument.getHeight());
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

    public List<Brush> getBrushes() {
        return brushes;
    }
    
    
}
