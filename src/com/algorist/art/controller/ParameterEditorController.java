/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.algorist.art.controller;

import com.algorist.art.model.brushes.Brush;
import java.util.List;
import javax.swing.JCheckBox;
import javax.swing.JSlider;
import mvc.AbstractController;
import mvc.AbstractFrame;

/**
 *
 * @author alan.jbssa
 */
public class ParameterEditorController extends AbstractController {
    
    private Brush brush;
    
    private List<JSlider> sliders;
    private List<JCheckBox> checkboxes;

    public ParameterEditorController(AbstractFrame mainFrame) {
        super(mainFrame);
    }

    public Brush getBrush() {
        return brush;
    }

    public void setBrush(Brush brush) {
        this.brush = brush;
    }
    
    
    
    
    
    
}
