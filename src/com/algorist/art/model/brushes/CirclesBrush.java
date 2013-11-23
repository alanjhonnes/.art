/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.algorist.art.model.brushes;

import com.algorist.art.model.Layer;
import com.algorist.art.model.Movement;
import com.algorist.art.model.brushes.parameters.FloatParameter;
import com.algorist.art.model.brushes.parameters.IntParameter;
import com.algorist.art.model.brushes.parameters.Parameter;
import com.algorist.art.model.brushes.presets.Preset;
import com.algorist.art.model.brushes.presets.SmallCircleBrushPreset;
import com.algorist.art.model.brushes.presets.ThickCircleBrushPreset;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.util.List;
import java.util.Map;

/**
 *
 * @author alan.jbssa
 */
public class CirclesBrush extends Brush {

    public int thickness = 20;
    public float red = 0;
    public float green = 0;
    public float blue = 0;
    public float opacity = 0.2f;
    public float hardness;

    public CirclesBrush() {
        super();
        this.name = "Circulos";
    }

    @Override
    public void loadDefaultPresets() {
        presets.add(new SmallCircleBrushPreset());
        presets.add(new ThickCircleBrushPreset());
    }

    @Override
    public void loadPreset(Preset preset) {
        if(preset.getBrushClass() == this.getClass()){
            Map<String, Object> params = preset.getParams();
            this.thickness = (int) params.get("thickness");
            this.opacity = (float) params.get("opacity");
        }
    }

    @Override
    public void draw(Movement movement) {
        Graphics2D g = (Graphics2D) layer.getImage().createGraphics();
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g.setColor(new Color(red, green, blue, opacity));
        g.fillOval(movement.getNewPosition().x - thickness /2, movement.getNewPosition().y - thickness / 2, thickness, thickness);
    }

    @Override
    public void initialize(Layer layer) {
    }

    @Override
    public List<Parameter> getParamTypes() {
        params.clear();
        params.add(new IntParameter("thickness", 1, 100, thickness));
        params.add(new FloatParameter("opacity", 0, 1, opacity));
        return params;
    }
    
    
}
