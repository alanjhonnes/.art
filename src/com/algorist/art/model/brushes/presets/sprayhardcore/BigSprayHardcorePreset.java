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
        params.put("bigOffset", 20);
        params.put("smallOffset", 5);
        params.put("red", 1f);
        params.put("green", 0.5f);
        params.put("blue", 0.2f);
        params.put("alpha", 1f);
    }
    
}
