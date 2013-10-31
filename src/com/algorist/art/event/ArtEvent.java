/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.algorist.art.event;

import com.alanjhonnes.event.Event;
import com.alanjhonnes.event.IEventDispatcher;
import com.algorist.art.model.Document;
import com.algorist.art.model.Movement;
import com.algorist.art.model.brushes.Brush;

/**
 *
 * @author user
 */
public class ArtEvent extends Event {
    
    public static final String BRUSH_CHANGED = "brushChanged";
    public static final String DOCUMENT_ADDED = "documentAdded";
    public static final String DOCUMENT_REMOVED = "documentRemoved";
    public static final String DOCUMENT_CHANGED = "documentChanged";
    public static final String MOVEMENT_STARTED = "movementStarted";
    public static final String MOVEMENT_ENDED = "movementEnded";
    
    private Document document;
    private Brush brush;
    private Movement movement;

    public ArtEvent(IEventDispatcher source, String type) {
        super(source, type);
    }
    
    public ArtEvent(IEventDispatcher source, String type, Document document) {
        super(source, type);
        this.document = document;
    }
    
    public ArtEvent(IEventDispatcher source, String type, Brush brush) {
        super(source, type);
        this.brush = brush;
    }
    
    public ArtEvent(IEventDispatcher source, String type, Movement movement) {
        super(source, type);
        this.movement = movement;
    }

    public Document getDocument() {
        return document;
    }

    public void setDocument(Document document) {
        this.document = document;
    }

    public Brush getBrush() {
        return brush;
    }

    public void setBrush(Brush brush) {
        this.brush = brush;
    }

    public Movement getMovement() {
        return movement;
    }

    public void setMovement(Movement movement) {
        this.movement = movement;
    }
    
    
    
    
    
    
    
}
