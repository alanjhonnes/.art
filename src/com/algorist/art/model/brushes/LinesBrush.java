/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.algorist.art.model.brushes;

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
    public void draw() {
        
    }

    @Override
    public void loadDefaultPresets() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Map<String, Parameter> getParamTypes() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
