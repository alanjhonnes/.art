/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.algorist.art.model.brushes.parameters;

/**
 *
 * @author alan.jbssa
 */
public class DoubleParameter extends Parameter {
    private double min;
    private double max;
    private double value;

    public DoubleParameter(String key, String label, double min, double max, double value) {
        super(key, label);
        this.min = min;
        this.max = max;
        this.value = value;
        this.type = double.class;
    }

    public double getMin() {
        return min;
    }

    public void setMin(double min) {
        this.min = min;
    }

    public double getMax() {
        return max;
    }

    public void setMax(double max) {
        this.max = max;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }
    
    
    
}
