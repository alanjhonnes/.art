/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.algorist.art.model.brushes.presets;

/**
 *
 * @author senac2012
 */
public class ThickCircleBrushPreset extends Preset {

    public ThickCircleBrushPreset() {
        super();
        this.name = "Grosso";
        params.put("thickness", new Float(1));
        params.put("opacity", new Float(1));
    }
    
}
