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
class DoubleSlider extends JSlider {

    final int scale;

    public DoubleSlider(int min, int max, int value, int scale) {
        super(min, max, value);
        this.scale = scale;
    }

    public double getScaledValue() {
        return ((double) super.getValue()) / this.scale;
    }
}
