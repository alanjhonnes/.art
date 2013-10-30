/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.algorist.art.model;

import com.alanjhonnes.event.EventDispatcher;
import com.algorist.art.model.brushes.Brush;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import javax.swing.JTable;

/**
 * Main model class, contains the whole list of openned documents. 
 * @author senac2012
 */
public class Art extends EventDispatcher {
    
    private Brush selectedBrush;
    private List<Document> documents;
    private Document currentDocument;

    public Art() {
        documents = new ArrayList<>();
    }

    public Brush getSelectedBrush() {
        return selectedBrush;
    }

    public void setSelectedBrush(Brush selectedBrush) {
        this.selectedBrush = selectedBrush;
    }
    
    public Document getCurrentDocument() {
        return currentDocument;
    }

    public void setCurrentDocument(Document currentDocument) {
        this.currentDocument = currentDocument;
    }

    public List<Document> getDocuments() {
        return documents;
    }

    public void setDocuments(List<Document> documents) {
        this.documents = documents;
    }
    
    
    
    
    
    
    
}
