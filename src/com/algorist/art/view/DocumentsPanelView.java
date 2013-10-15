/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.algorist.art.view;

import com.algorist.art.model.Art;
import java.util.Observer;
import javax.swing.JTabbedPane;
import mvc.AbstractFrame;
import mvc.AbstractView;

/**
 *
 * @author alan.jbssa
 */
public class DocumentsPanelView extends AbstractView<JTabbedPane> implements Observer{

    private Art artModel;

    public DocumentsPanelView(AbstractFrame mainFrame, Art artModel) {
        super(mainFrame);
        this.artModel = artModel;
        artModel.addObserver(this);
    }
    
    
    @Override
    protected JTabbedPane layout() {
        JTabbedPane tabbedPane = new JTabbedPane();
        return tabbedPane;
    }
    
    
    
}
