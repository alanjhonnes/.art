/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.algorist.art.view.display;

/**
 * DoubleSlider allows a float parameter to be represented by whole numbers and 
 * then scaled onto its float version. ie: 0-100 with a scale of 100 will 
 * represent a float value of 0-1
 * @author alan.jbssa
 */
public class DoubleSlider extends IntSlider {

    final int scale;

    public DoubleSlider(String key, int min, int max, int value, int scale) {
        super(key, min, max, value);
        this.scale = scale;
    }

    public double getScaledValue() {
        return ((double) super.getValue()) / this.scale;
    }
    
    
}
