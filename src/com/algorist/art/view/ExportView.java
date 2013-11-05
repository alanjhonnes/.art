/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.algorist.art.view;

import com.algorist.art.view.display.ExportPanel;
import javax.swing.JComponent;
import mvc.AbstractFrame;
import mvc.AbstractView;

/**
 *
 * @author Asus
 */
public class ExportView extends AbstractView<ExportPanel>{

    public ExportView(AbstractFrame mainFrame) {
        super(mainFrame);
    }

    @Override
    protected ExportPanel layout() {
       ExportPanel panel = new ExportPanel();
       return panel;
        
    }
    
}
