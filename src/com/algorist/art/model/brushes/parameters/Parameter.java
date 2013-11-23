/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.algorist.art.model.brushes.parameters;

/**
 *
 * @author user
 */
public abstract class Parameter {

    protected String key;
    protected Class type;

    public Parameter(String key) {
        this.key = key;
    }

    public Class getType() {
        return type;
    }

    public void setType(Class type) {
        this.type = type;
    }

}
