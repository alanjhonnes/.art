/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.algorist.art.view.display;

import javax.swing.JCheckBox;

/**
 * A regular checkbox that stores the field name of the parameter it is 
 * representing.
 * @author alan.jbssa
 */
public class BooleanCheckbox extends JCheckBox implements IParameterComponent {
    private String key;

    public BooleanCheckbox(String key, boolean value, String text) {
        super(text);
        this.setSelected(value);
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
