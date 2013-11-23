/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.algorist.art.model.brushes.presets.sprayhardcore;

import com.algorist.art.model.brushes.SprayHardcoreBrush;
import com.algorist.art.model.brushes.presets.Preset;
import java.util.HashMap;

/**
 *
 * @author alan.jbssa
 */
public class SmallSprayHardcorePreset extends Preset{

    public SmallSprayHardcorePreset() {
        this.setName("Pequeno");
        this.setBrushClass(SprayHardcoreBrush.class);
        this.params = new HashMap<>();
        params.put("radius", 8);
    }
    
    
    
}
