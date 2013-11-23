/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.algorist.art.model.brushes.parameters;


/**
 *
 * @author alanjhonnes
 */
public class FloatParameter extends Parameter {

    public float min;
    public float max;

    public FloatParameter(String key, float min, float max) {
        super(key);
        this.min = min;
        this.max = max;
        this.type = float.class;
    }
    
    
}
