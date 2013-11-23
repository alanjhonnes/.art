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
    private float value;

    public FloatParameter(String key, float min, float max, float value) {
        super(key);
        this.min = min;
        this.max = max;
        this.value = value;
        this.type = float.class;
    }

    public float getMin() {
        return min;
    }

    public void setMin(float min) {
        this.min = min;
    }

    public float getMax() {
        return max;
    }

    public void setMax(float max) {
        this.max = max;
    }

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }
    
    
    
}
