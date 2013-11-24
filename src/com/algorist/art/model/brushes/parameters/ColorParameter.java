/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.algorist.art.model.brushes.parameters;

import java.awt.Color;

/**
 *
 * @author alanjhonnes
 */
public class ColorParameter extends Parameter {
    
    private Color value;

    public ColorParameter(String key, String label, Color value) {
        super(key, label);
        this.value = value;
        this.type = Color.class;
    }

    public Color getValue() {
        return value;
    }

    public void setValue(Color value) {
        this.value = value;
    }

    
    
}
