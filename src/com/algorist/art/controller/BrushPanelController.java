/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.algorist.art.controller;

import com.algorist.art.model.Art;
import com.algorist.art.model.brushes.Brush;
import com.algorist.art.model.brushes.presets.Preset;
import com.algorist.art.view.ParameterEditorView;
import java.util.List;
import mvc.AbstractController;
import mvc.AbstractFrame;

/**
 *
 * @author alanjhonnes
 */
public class BrushPanelController extends AbstractController {

    private Art artModel;
    
    public BrushPanelController(AbstractFrame mainFrame, Art artModel) {
        super(mainFrame);
        this.artModel = artModel;
    }
    
    public List<Brush> getBrushes(){
        return artModel.getBrushes();
    }

    public void changeBrush(Brush brush) {
        artModel.setSelectedBrush(brush);
    }

    public void changePreset(Preset preset) {
        artModel.getSelectedBrush().loadPreset(preset);
        getMainFrame().getView(ParameterEditorView.class).setupParams(artModel.getSelectedBrush().getParamTypes());
    }
    
}
