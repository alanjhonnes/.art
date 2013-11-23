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
        params.put("bigOffset", 8);
        params.put("smallOffset", 2);
        params.put("red", 0.5f);
        params.put("green", 1f);
        params.put("blue", 0.1f);
        params.put("alpha", 1f);
    }
    
    
    
}
