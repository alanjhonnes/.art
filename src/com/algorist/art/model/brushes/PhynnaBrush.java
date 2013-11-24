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
import java.awt.RenderingHints;
import java.util.Map;

/**
 *
 * @author alan.jbssa
 */
public class PhynnaBrush extends Brush {
    
     public PhynnaBrush() {
        name = "Phynna";
    }    

    @Override
    public void draw(Movement movement) {
        Graphics2D g = layer.getImage().createGraphics();
        g.setColor(Color.DARK_GRAY);
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
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

    
}
