/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.algorist.art.model.brushes;

import com.algorist.art.model.Layer;
import com.algorist.art.model.Movement;
import com.algorist.art.model.brushes.parameters.Parameter;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;
import javax.swing.Timer;

/**
 *
 * @author alan.jbssa
 */
public class RB2_Brush extends Brush {

    @Override
    public void initialize(Layer layer) {
    }

    @Override
    public void draw(Movement movement) {
        Graphics2D g = layer.getImage().createGraphics();
        g.setColor(Color.DARK_GRAY);
        int[] xs = {-50, 0, 50, 10, 50, 0, -50, -10, -50};
        int[] ys = {-50, -10, -50, 0, 50, 10, 50, 0,-50};
        for (int i = 0; i < xs.length; i++) {
            int j = xs[i];
            xs[i] = j + movement.getNewPosition().x;
            j = ys[i];
            ys[i] = j + movement.getNewPosition().y;
        }
        g.drawPolyline(xs, ys, 9);
    }

    @Override
    public void loadDefaultPresets() {
    }

    @Override
    public Map<String, Parameter> getParamTypes() {
        return null;
    }
}
