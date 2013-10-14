/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.algorist.art.model.brushes;

import com.algorist.art.model.brushes.presets.Preset;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;

/**
 *
 * @author alan.jbssa
 */
public abstract class Brush {
    
    protected String name;
    protected List<Preset> presets;

    public Brush() {
        presets = new ArrayList<>();
        loadDefaultPresets();
    }

    public Brush(List<Preset> presets) {
        this.presets = presets;
    }
    
    abstract public void draw();
    
    public abstract void loadDefaultPresets();
    
    
    
    public abstract Map<String, Class> getParamTypes();
    
    public void loadPreset(Preset preset){
        if(preset.getBrushClass() == this.getClass()){
            
        }
        else {
            System.err.println("Error loading preset. Preset brushClass is diferent from brush class.");
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Preset> getPresets() {
        return presets;
    }

    public void setPresets(List<Preset> presets) {
        this.presets = presets;
    }

    @Override
    public String toString() {
        return name;
    }
    
    
    
}
