/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.algorist.art.model.brushes.presets.silkbrush;

import com.algorist.art.model.brushes.SilkBrush;
import com.algorist.art.model.brushes.presets.Preset;
import java.util.HashMap;

/**
 *
 * @author alan.jbssa
 */
public class HighSpreadSilkBrushPreset extends Preset {

    public HighSpreadSilkBrushPreset() {
        this.setName("High spread");
        this.setBrushClass(SilkBrush.class);
        this.params = new HashMap<>();
        params.put("maxDist", 50);
        params.put("opacity", 0.2f);
        params.put("density", 1d);
        params.put("spread", 250);
        params.put("bumpmapScale", 100);
        params.put("bumpmapEffect", 0.4d);
        params.put("scatter", 50);
        params.put("lifespan", 10);
        params.put("shadowMaxDist", 100);
        params.put("shadowOpacity", 0.075f);
        params.put("shadowDensity", 0.8d);
        params.put("shadowSpread", 500);
        params.put("shadowScatter", 50);
        params.put("shadowLifespan", 4);
        params.put("useShadows", true);
    }
    
}
