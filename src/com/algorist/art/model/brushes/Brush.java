/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.algorist.art.model.brushes;

import com.algorist.art.model.brushes.presets.Preset;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

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
    
    public void loadPreset(Preset preset){
        if(preset.getBrushClass() != this.getClass()){
            
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