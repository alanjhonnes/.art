/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.algorist.art.controller;

import com.algorist.art.event.ArtEvent;
import com.algorist.art.model.Art;
import com.algorist.art.model.Document;
import com.algorist.art.view.DocumentsView;
import mvc.AbstractController;
import mvc.AbstractFrame;

/**
 *
 * @author alanjhonnes
 */
public class DocumentsController extends AbstractController {
    
    private Art artModel;
    private DocumentsView view;
    
    public DocumentsController(AbstractFrame mainFrame, Art artModel) {
        super(mainFrame);
        this.artModel = artModel;
    }

    public DocumentsView getView() {
        return view;
    }

    public void setView(DocumentsView view) {
        this.view = view;
    }
    
    public void currentDocumentChanged(Document document){
        artModel.setCurrentDocument(document);
    }
    
}
