/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.algorist.art.model.brushes.presets;

import java.util.HashMap;
import java.util.Map;

/**
 * Represent a brush preset, containing a map of field names and parameters.
 * @author alan.jbssa
 */
public class Preset {
    protected String name;
    protected Class brushClass;
    protected Map<String, Object> params;

    public Preset() {
        params = new HashMap<>();
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<String, Object> getParams() {
        return params;
    }

    public void setParams(Map<String, Object> params) {
        this.params = params;
    }

    public Class getBrushClass() {
        return brushClass;
    }

    public void setBrushClass(Class brushClass) {
        this.brushClass = brushClass;
    }

  @Override
  public String toString() {
    return this.name;
  }
    
    
    
    
    
    
}
