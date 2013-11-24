/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.algorist.art.model.brushes.presets.circle;

import com.algorist.art.model.brushes.CirclesBrush;
import com.algorist.art.model.brushes.SilkBrush;
import com.algorist.art.model.brushes.presets.Preset;

/**
 *
 * @author alanjhonnes
 */
public class ThickCircleBrushPreset extends Preset {

    public ThickCircleBrushPreset() {
        this.name = "Grande";
        this.setBrushClass(CirclesBrush.class);
        params.put("thickness", 50);
    }
    
}
