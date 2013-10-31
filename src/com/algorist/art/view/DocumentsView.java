/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.algorist.art.view;

import com.alanjhonnes.event.CallbackFunction;
import com.alanjhonnes.event.Event;
import com.algorist.art.controller.DocumentsController;
import com.algorist.art.event.ArtEvent;
import com.algorist.art.model.Art;
import java.util.Observer;
import javax.swing.JTabbedPane;
import mvc.AbstractFrame;
import mvc.AbstractView;

/**
 *
 * @author alan.jbssa
 */
public class DocumentsView extends AbstractView<JTabbedPane> {

    private Art artModel;
    private DocumentsController controller;

    public DocumentsView(AbstractFrame mainFrame, Art artModel, DocumentsController controller) {
        super(mainFrame);
        this.artModel = artModel;
        
        this.controller = controller;
        
        artModel.addEventListener(ArtEvent.DOCUMENT_ADDED, new CallbackFunction() {

            @Override
            public void execute(Event e) {
                //TODO
            }
        });
        
        artModel.addEventListener(ArtEvent.DOCUMENT_REMOVED, new CallbackFunction() {

            @Override
            public void execute(Event e) {
                //TODO
            }
        });
        
    }
    
    
    @Override
    protected JTabbedPane layout() {
        JTabbedPane tabbedPane = new JTabbedPane();
        return tabbedPane;
    }
    
    
    
}
