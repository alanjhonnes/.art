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
class FloatSlider extends JSlider {

    final int scale;

    public FloatSlider(int min, int max, int value, int scale) {
        super(min, max, value);
        this.scale = scale;
    }

    public float getScaledValue() {
        return ((float)super.getValue()) / this.scale;
    }
}
