/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.algorist.art.controller;

import com.algorist.art.model.brushes.Brush;
import java.util.List;
import mvc.AbstractController;
import mvc.AbstractFrame;

/**
 *
 * @author senac2012
 */
public class BrushPanelController extends AbstractController {

    public BrushPanelController(AbstractFrame mainFrame) {
        super(mainFrame);
    }
    
    public List<Brush> getBrushes(){
        return null;
    }
    
}
