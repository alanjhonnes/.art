/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.algorist.art.controller;

import com.alanjhonnes.event.CallbackFunction;
import com.alanjhonnes.event.Event;
import com.algorist.art.event.ArtEvent;
import com.algorist.art.model.Art;
import com.algorist.art.model.brushes.Brush;
import com.algorist.art.model.brushes.parameters.Parameter;
import com.algorist.art.view.ParameterEditorView;
import java.awt.Color;
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
    private Art artModel;
    private ParameterEditorView view;

    public ParameterEditorController(AbstractFrame mainFrame, Art artModel) {
        super(mainFrame);
        this.artModel = artModel;
        artModel.addEventListener(ArtEvent.BRUSH_CHANGED, new CallbackFunction() {

            @Override
            public void execute(Event e) {
                ArtEvent ae = (ArtEvent) e;
                brush = ae.getBrush();
                setupView(brush.getParamTypes());
            }
        });
    }
    
    public void setupView(List<Parameter> params){
        if(view != null){
            view.setupParams(params);
        }
    }

    public Brush getBrush() {
        return brush;
    }

    public void setBrush(Brush brush) {
        this.brush = brush;
    }

    public ParameterEditorView getView() {
        return view;
    }

    public void setView(ParameterEditorView view) {
        this.view = view;
    }

    public void intChanged(String key, int value) {
        brush.setField(key, value);
    }

    public void floatChanged(String key, float value) {
        brush.setField(key, value);
    }

    public void doubleChanged(String key, double value) {
        brush.setField(key, value);
    }
    
    public void booleanChanged(String key, boolean value) {
        brush.setField(key, value);
    }
    
    public void colorChanged(String key, Color value) {
        brush.setField(key, value);
    }
    
    
    
    
    
    
}
