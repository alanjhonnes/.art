/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.algorist.art.model.brushes.presets.sprayhardcore;

import com.algorist.art.model.brushes.SilkBrush;
import com.algorist.art.model.brushes.SprayHardcoreBrush;
import com.algorist.art.model.brushes.presets.Preset;
import java.util.HashMap;

/**
 *
 * @author alan.jbssa
 */
public class BigSprayHardcorePreset extends Preset {

    public BigSprayHardcorePreset() {
        this.setName("Grande");
        this.setBrushClass(SprayHardcoreBrush.class);
        this.params = new HashMap<>();
        params.put("radius", 50);
    }
    
}
