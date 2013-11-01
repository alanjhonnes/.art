/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.algorist.art.model.brushes.presets;

import com.alanjhonnes.event.EventDispatcher;
import java.util.HashMap;
import java.util.Map;
import java.util.Observable;

/**
 *
 * @author alan.jbssa
 */
public class Preset extends EventDispatcher {
    protected String name;
    protected Class brushClass;
    protected Map<Object, Object> params;

    public Preset() {
        params = new HashMap<>();
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<Object, Object> getParams() {
        return params;
    }

    public void setParams(Map<Object, Object> params) {
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
