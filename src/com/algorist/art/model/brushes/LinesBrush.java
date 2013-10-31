/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.algorist.art.model.brushes;

import com.algorist.art.model.Layer;
import com.algorist.art.model.Movement;
import com.algorist.art.model.brushes.parameters.Parameter;
import java.util.Map;

/**
 *
 * @author alan.jbssa
 */
public class LinesBrush extends Brush {

    public LinesBrush() {
        super();
        this.name = "Linhas";
    }

    @Override
    public void loadDefaultPresets() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Map<String, Parameter> getParamTypes() {
        return null;
    }

    @Override
    public void initialize() {
    }

    @Override
    public void draw() {
    }

    @Override
    public void startDrawing(Movement movement, Layer layer) {
    }

    @Override
    public void stopDrawing(Movement movement) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    
}
