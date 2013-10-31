/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.algorist.art.view;

import com.alanjhonnes.event.CallbackFunction;
import com.alanjhonnes.event.Event;
import com.algorist.art.event.DocumentEvent;
import com.algorist.art.model.Document;
import javax.swing.JPanel;
import mvc.AbstractFrame;
import mvc.AbstractView;

/**
 *
 * @author alan.jbssa
 */
public class DocumentView extends AbstractView<JPanel>{
    
    private Document documentModel;

    public DocumentView(AbstractFrame mainFrame, Document documentModel) {
        super(mainFrame);
        this.documentModel = documentModel;
        this.documentModel.addEventListener(DocumentEvent.SIZE_CHANGED, new CallbackFunction() {

            @Override
            public void execute(Event e) {
                //TODO
            }
        });
        this.documentModel.addEventListener(DocumentEvent.SIZE_CHANGED, new CallbackFunction() {

            @Override
            public void execute(Event e) {
                //TODO
            }
        });
    }
    
    

    @Override
    protected JPanel layout() {
        JPanel panel = new JPanel();
        return panel;
    }
    
}
