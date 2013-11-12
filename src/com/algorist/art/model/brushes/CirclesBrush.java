/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.algorist.art.model.brushes;

import com.alanjhonnes.event.CallbackFunction;
import com.alanjhonnes.event.Event;
import com.algorist.art.event.MovementEvent;
import com.algorist.art.model.Layer;
import com.algorist.art.model.Movement;
import com.algorist.art.model.brushes.parameters.IntParameter;
import com.algorist.art.model.brushes.parameters.ColorParameter;
import com.algorist.art.model.brushes.parameters.FloatParameter;
import com.algorist.art.model.brushes.parameters.Parameter;
import com.algorist.art.model.brushes.presets.Preset;
import com.algorist.art.model.brushes.presets.SmallCircleBrushPreset;
import com.algorist.art.model.brushes.presets.ThickCircleBrushPreset;
import java.awt.AlphaComposite;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.Stroke;
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
    public void loadDefaultPresets() {
        presets.add(new SmallCircleBrushPreset());
        presets.add(new ThickCircleBrushPreset());
    }

    @Override
    public Map<String, Parameter> getParamTypes() {
        Map<String, Parameter> map = new HashMap<>();
        map.put("thickness", new IntParameter(1, 100));
        map.put("color", new ColorParameter());
        map.put("stepDuration", new IntParameter(1, 100));
        map.put("opacity", new FloatParameter(0, 1));
        map.put("hardness", new FloatParameter(0, 1));
        return map;

    }

    @Override
    public void loadPreset(Preset preset) {
        Map<Object, Object> map = preset.getParams();
        this.thickness = (Integer) map.get("thickness");

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
}
