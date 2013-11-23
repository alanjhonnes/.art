/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.algorist.art.view;

import com.algorist.art.model.brushes.Brush;
import javax.swing.JPanel;
import mvc.AbstractFrame;
import mvc.AbstractView;

/**
 *
 * @author alan.jbssa
 */
public class ParameterEditorView extends AbstractView<JPanel> {
    
    

    public ParameterEditorView(AbstractFrame mainFrame) {
        super(mainFrame);
    }
    
    private Brush brush;

    @Override
    protected JPanel layout() {
        JPanel panel = new JPanel();
        return panel;
    }

    public Brush getBrush() {
        return brush;
    }

    public void setBrush(Brush brush) {
        this.brush = brush;
    }
    
}
