/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.algorist.art.view.display;

/**
 *
 * @author alan.jbssa
 */
public class FloatSlider extends IntSlider {

    final int scale;

    public FloatSlider(String key, int min, int max, int value, int scale) {
        super(key, min, max, value);
        this.scale = scale;
    }

    public float getScaledValue() {
        return ((float)super.getValue()) / this.scale;
    }
}
