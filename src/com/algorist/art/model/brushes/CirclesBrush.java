/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.algorist.art.model.brushes;

import com.algorist.art.model.Layer;
import com.algorist.art.model.Movement;
import com.algorist.art.model.brushes.parameters.FloatParameter;
import com.algorist.art.model.brushes.parameters.IntParameter;
import com.algorist.art.model.brushes.presets.Preset;
import com.algorist.art.model.brushes.presets.SmallCircleBrushPreset;
import com.algorist.art.model.brushes.presets.ThickCircleBrushPreset;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
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
    public void loadDefaultPresets() {
        presets.add(new SmallCircleBrushPreset());
        presets.add(new ThickCircleBrushPreset());
    }

    @Override
    public void loadPreset(Preset preset) {
        Map<String, Object> params = preset.getParams();
        this.thickness = (int) params.get("thickness");

    }

    @Override
    public void draw(Movement movement) {
        Graphics2D g = (Graphics2D) layer.getImage().createGraphics();
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g.setColor(new Color(0f, 0f, 0f, 0.2f));
        g.fillOval(movement.getNewPosition().x, movement.getNewPosition().y, 18, 18);
    }

    @Override
    public void initialize(Layer layer) {
    }

    @Override
    public void defineParameters() {
        params.add(new IntParameter("thickness", 1, 100));
        params.add(new FloatParameter("opacity", 0, 1));
        params.add(new FloatParameter("hardness", 0, 1));
    }
}
