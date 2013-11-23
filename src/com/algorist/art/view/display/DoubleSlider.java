/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.algorist.art.view.display;

import javax.swing.JSlider;

/**
 *
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
