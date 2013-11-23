/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.algorist.art.model.brushes.parameters;

/**
 *
 * @author user
 */
public class IntParameter extends Parameter {

    public int min;
    public int max;

    public IntParameter(String key, int min, int max) {
        super(key);
        this.min = min;
        this.max = max;
        this.type = int.class;
    }
}
