/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.algorist.art.model.brushes.parameters;

/**
 *
 * @author user
 */
public class IntParameter extends Parameter {

    private int min;
    private int max;
    private int value;

    public IntParameter(String key, String label, int min, int max, int value) {
        super(key, label);
        this.min = min;
        this.max = max;
        this.value = value;
        this.type = int.class;
    }

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
    
    
    
    
}
