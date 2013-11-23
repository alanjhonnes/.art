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
import java.util.Map;

/**
 *
 * @author alan.jbssa
 */
public class SprayHardcoreBrush extends Brush {

    private int smallOffset = 2;
    private int bigOffset = 8;
    private Color color;

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
        g.setColor(color);

        for (int i = 0; i < 35; i++) {
            // use static final ints now
            tempx = (x + (int) Math.round(2 * smallOffset * (Math.random() - 0.5)));
            tempy = (y + (int) (((Math.random() - 0.5) * 2) * Math.sqrt(
                    (smallOffset * smallOffset) - ((x - tempx) * (x - tempx)))));
            g.drawLine((int) tempx, (int) tempy, (int) tempx, (int) tempy);
        }

        for (int i = 0; i < 12; i++) {
            tempx = (x + (int) Math.round(2 * bigOffset * (Math.random() - 0.5)));
            tempy = (y + (int) (((Math.random() - 0.5) * 2) * Math.sqrt(
                    (bigOffset * bigOffset) - ((x - tempx) * (x - tempx)))));
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
            this.bigOffset = (int) params.get("bigOffset");
            this.smallOffset = (int) params.get("smallOffset");

            float red = (float) params.get("red");
            float green = (float) params.get("green");
            float blue = (float) params.get("blue");
            float alpha = (float) params.get("alpha");
            this.color = new Color(red, green, blue, alpha);
        }
    }

    @Override
    public void defineParameters() {
        
    }
}
