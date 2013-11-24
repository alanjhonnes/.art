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
import com.algorist.art.model.brushes.RB2_Brush;
import com.algorist.art.model.brushes.RB3_Brush;
import com.algorist.art.model.brushes.RB4_Brush;
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
        brushes.add(new RB2_Brush());
        brushes.add(new RB3_Brush());
        brushes.add(new RB4_Brush());
        brushes.add(new SprayHardcoreBrush());
           
        
        setSelectedBrush(brushes.get(0));
    }
    
    public void addDocument(Document document){
        documents.add(document);
        dispatchEvent(new ArtEvent(document, ArtEvent.DOCUMENT_ADDED, document));
    }
    
    public void removeDocument(Document document){
        documents.remove(document);
        dispatchEvent(new ArtEvent(document, ArtEvent.DOCUMENT_REMOVED, document));
        document.dispose();
    }
    
    public void startMovement(Movement movement){
        movements.add(movement);
        dispatchEvent(new ArtEvent(this, ArtEvent.MOVEMENT_STARTED, movement));
    }
    
    public void endMovement(Movement movement){
        movements.remove(movement);
        dispatchEvent(new ArtEvent(this, ArtEvent.MOVEMENT_ENDED, movement));
        movement.stop();
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
