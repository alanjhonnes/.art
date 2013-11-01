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
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
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
        drawCallback = new CallbackFunction() {

            @Override
            public void execute(Event e) {
                MovementEvent me = (MovementEvent) e;
                Movement movement = (Movement) e.getSource();
                Graphics2D g = (Graphics2D) layer.getImage().createGraphics();
                g.setColor(Color.BLACK);
                g.drawOval(movement.getNewPosition().x, movement.getNewPosition().y, 5, 5);
                
            }
        };
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
    public void draw() {
    }

    @Override
    public void initialize() {
    }
    
    
    
    
    
}
