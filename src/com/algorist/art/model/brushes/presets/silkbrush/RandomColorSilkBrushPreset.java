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
public class RandomColorSilkBrushPreset extends Preset {
    public RandomColorSilkBrushPreset() {
        this.setName("Cor aleatória");
        this.setBrushClass(SilkBrush.class);
        this.params = new HashMap<>();
        params.put("maxDist", 60);
        params.put("opacity", 0.2f);
        params.put("density", 1d);
        params.put("spread", 90);
        params.put("bumpmapScale", 100);
        params.put("bumpmapEffect", 0.4d);
        params.put("scatter", 0);
        params.put("lifespan", 10);
        params.put("shadowMaxDist", 120);
        params.put("shadowOpacity", 0.075f);
        params.put("shadowDensity", 0.8d);
        params.put("shadowSpread", 300);
        params.put("shadowScatter", 0);
        params.put("shadowLifespan", 4);
        params.put("useShadows", true);
        params.put("useRandomColor", true);
        params.put("red", 1f);
        params.put("green", 1f);
        params.put("blue", 1f);
        
    }
}
