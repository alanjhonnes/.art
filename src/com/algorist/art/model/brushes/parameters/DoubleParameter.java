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
    public double min;
    public double max;

    public DoubleParameter(String key, double min, double max) {
        super(key);
        this.min = min;
        this.max = max;
        this.type = double.class;
    }
}
