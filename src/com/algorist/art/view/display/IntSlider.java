/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.algorist.art.view.display;

import java.awt.Dimension;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.Hashtable;
import javax.swing.JLabel;
import javax.swing.JSlider;

/**
 * Slider that stores the field name of the parameter it represents.
 * Base class for DoubleSlider and FloatSlider.
 * @author alan.jbssa
 */
public class IntSlider extends JSlider implements IParameterComponent {

    private String key;

    public IntSlider(String key, int min, int max, int value) {
        super(min, max, value);
        this.setPaintTicks(true);
        this.setPaintLabels(true);
        Dictionary<Integer, JLabel> labels = new Hashtable<>();
        labels.put(new Integer(min), new JLabel(String.valueOf(min)));
        int avg = max / 2;
        labels.put(new Integer(avg), new JLabel(String.valueOf(avg)));
        labels.put(new Integer(max), new JLabel(String.valueOf(max)));
        setLabelTable(labels);
        setMajorTickSpacing(avg);
        setPreferredSize(new Dimension(100, 44));
        this.key = key;
    }
    
    @Override
    public void setKey(String key) {
        this.key = key;
    }

    @Override
    public String getKey() {
        return key;
    }
    
}
