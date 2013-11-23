/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.algorist.art.model.brushes.parameters;

/**
 *
 * @author alan.jbssa
 */
public class BooleanParameter extends Parameter {
    
    private boolean value;

    public BooleanParameter(String key, boolean value) {
        super(key);
        this.value = value;
        this.type = boolean.class;
    }

    public boolean getValue() {
        return value;
    }

    public void setValue(boolean value) {
        this.value = value;
    }
    
}
