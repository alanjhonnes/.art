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
import com.algorist.art.model.brushes.parameters.Parameter;
import com.algorist.art.model.brushes.presets.Preset;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author alan.jbssa
 */
public abstract class Brush {

    protected String name;
    protected BufferedImage image;
    protected List<Preset> presets;
    protected Layer layer;
    protected CallbackFunction drawCallback;
    protected List<Parameter> params;

    public Brush() {
        presets = new ArrayList<>();
        params = new ArrayList<>();
        drawCallback = new CallbackFunction() {
            @Override
            public void execute(Event e) {
                MovementEvent me = (MovementEvent) e;
                Movement movement = (Movement) e.getSource();
                draw(movement);
            }
        };
        //defineParameters();
        loadDefaultPresets();
    }

    public Brush(List<Preset> presets) {
        this.presets = presets;
    }

    abstract public void initialize(Layer layer);

    public void startDrawing(Movement movement, Layer layer) {
        this.layer = layer;
        movement.addEventListener(MovementEvent.TIMER_TICK, drawCallback);
        //movement.addEventListener(MovementEvent.POSITION_CHANGED, drawCallback);
    }

    public void stopDrawing(Movement movement) {
        layer = null;
        movement.removeEventListener(MovementEvent.TIMER_TICK, drawCallback);
        //movement.removeEventListener(MovementEvent.POSITION_CHANGED, drawCallback);
    }

    abstract public void draw(Movement movement);

    public abstract void loadDefaultPresets();

    public void loadPreset(Preset preset) {
        if (preset.getBrushClass() == this.getClass()) {
        } else {
            System.err.println("Error loading preset. Preset brushClass is diferent from brush class.");
        }
    }

    public List<Parameter> getParamTypes() {
        return params;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Preset> getPresets() {
        return presets;
    }

    public void setPresets(List<Preset> presets) {
        this.presets = presets;
    }

    public BufferedImage getImage() {
        return image;
    }

    public void setImage(BufferedImage image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return name;
    }

    public void setField(String key, int value) {
        try {
            Field f = this.getClass().getDeclaredField(key);
            f.setInt(this, value);
        } catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException ex) {
            Logger.getLogger(Brush.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void setField(String key, float value) {
        try {
            Field f = this.getClass().getDeclaredField(key);
            f.setFloat(this, value);
        } catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException ex) {
            Logger.getLogger(Brush.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void setField(String key, double value) {
        try {
            Field f = this.getClass().getDeclaredField(key);
            f.setDouble(this, value);
        } catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException ex) {
            Logger.getLogger(Brush.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void setField(String key, boolean value) {
        try {
            Field f = this.getClass().getDeclaredField(key);
            f.setBoolean(this, value);
        } catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException ex) {
            Logger.getLogger(Brush.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void setField(String key, Color value) {
        try {
            Field f = this.getClass().getDeclaredField(key);
            f.set(this, value);
        } catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException ex) {
            Logger.getLogger(Brush.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public Object getField(String key){
        try {
            Field f = this.getClass().getDeclaredField(key);
            return f.get(this);
        } catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException ex) {
            Logger.getLogger(Brush.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
