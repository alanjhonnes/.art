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
import java.awt.Point;
import java.awt.Polygon;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.util.Map;

/**
 *
 * @author alan.jbssa
 */
public class AlchemyBrush extends Brush {

    public AlchemyBrush() {
        name = "Alchemy";
    }

    @Override
    public void draw(Movement movement) {

        Point p = movement.getNewPosition();
        int size = 10;

        Graphics2D g = layer.getImage().createGraphics();
        g.setColor(Color.darkGray);
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        Rectangle r = new Rectangle();
        int[] xpoints = new int[]{p.x, p.x + (size / 2), p.x + size};
        int[] ypoints = new int[]{p.y, p.y + size, p.y};
        Polygon pol = new Polygon(xpoints, ypoints, 3);
        g.draw(pol);
        r.setLocation(p);
        r.width = size;
        r.height = size;
    }

    @Override
    public void loadDefaultPresets() {
    }

}
