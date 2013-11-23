/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.algorist.art.view.display;

import java.awt.Color;
import javax.swing.JColorChooser;

/**
 *
 * @author user
 */
public class ColorPicker extends JColorChooser implements IParameterComponent {

    private String key;
    
    public ColorPicker(String key) {
        this.key = key;
    }

    public ColorPicker(String key, Color initialColor) {
        super(initialColor);
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
