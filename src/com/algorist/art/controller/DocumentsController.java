/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.algorist.art.controller;

import com.algorist.art.model.Art;
import com.algorist.art.view.DocumentsView;
import mvc.AbstractController;
import mvc.AbstractFrame;

/**
 *
 * @author alanjhonnes
 */
public class DocumentsController extends AbstractController {
    
    private Art artModel;
    
    public DocumentsController(AbstractFrame mainFrame, Art artModel) {
        super(mainFrame);
        this.artModel = artModel;
    }
    
}
