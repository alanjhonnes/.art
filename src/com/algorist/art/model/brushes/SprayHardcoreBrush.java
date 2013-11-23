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
import com.algorist.art.model.brushes.presets.sprayhardcore.BigSprayHardcorePreset;
import com.algorist.art.model.brushes.presets.sprayhardcore.SmallSprayHardcorePreset;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.util.List;
import java.util.Map;

/**
 *
 * @author alan.jbssa
 */
public class SprayHardcoreBrush extends Brush {

    public int radius = 8;
    public float red = 0;
    public float green = 0;
    public float blue = 1f;
    public float opacity = 1f;

    public SprayHardcoreBrush() {
        name = "SprayHardcore";
    }

    @Override
    public void initialize(Layer layer) {
    }

    @Override
    public void draw(Movement movement) {
        int x = 0, y = 0, tempx, tempy;
        x = movement.getNewPosition().x;
        y = movement.getNewPosition().y;
        Graphics2D g = layer.getImage().createGraphics();
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g.setColor(new Color(red, green, blue, opacity));


        for (int i = 0; i < 35; i++) {
            tempx = (x + (int) Math.round(2 * radius * (Math.random() - 0.5)));
            tempy = (y + (int) (((Math.random() - 0.5) * 2) * Math.sqrt(
                    (radius * radius) - ((x - tempx) * (x - tempx)))));
            g.drawLine((int) tempx, (int) tempy, (int) tempx, (int) tempy);
        }
    }

    @Override
    public void loadDefaultPresets() {
        presets.add(new SmallSprayHardcorePreset());
        presets.add(new BigSprayHardcorePreset());
    }

    @Override
    public void loadPreset(Preset preset) {
        if (preset.getBrushClass() == this.getClass()) {
            Map<String, Object> params = preset.getParams();
            this.radius = (int) params.get("radius");
        }
    }

    @Override
    public List<Parameter> getParamTypes() {
        params.clear();
        params.add(new IntParameter("radius", 1, 100, radius));
        params.add(new FloatParameter("red", 0, 1, red));
        params.add(new FloatParameter("green", 0, 1, green));
        params.add(new FloatParameter("blue", 0, 1, blue));
        params.add(new FloatParameter("opacity", 0, 1, opacity));
        return params;
    }
    
    
}
