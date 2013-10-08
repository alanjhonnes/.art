/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.algorist.art.model.brushes;

import com.algorist.art.model.brushes.presets.SmallCircleBrushPreset;
import com.algorist.art.model.brushes.presets.ThickCircleBrushPreset;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author alan.jbssa
 */
public class CirclesBrush extends Brush {
    
    private Integer thickness;
    private Integer color;
    private Integer stepDuration;
    private Float opacity;
    private Float hardness;

    public CirclesBrush() {
        super();
        this.name = "Circulos";
    }

    @Override
    public void draw() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void loadDefaultPresets() {
        presets.add(new SmallCircleBrushPreset());
        presets.add(new ThickCircleBrushPreset());
    }

    @Override
    public Map<String, Class> getParamTypes() {
        Map<String, Class> map = new HashMap<>();
        map.put("thickness", Integer.class);
        map.put("color", Integer.class);
        map.put("stepDuration", Integer.class);
        map.put("opacity", Float.class);
        map.put("hardness", Float.class);
        return map;
    }
    
}
