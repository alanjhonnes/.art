/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.algorist.art.model.brushes;

import com.algorist.art.model.Layer;
import com.algorist.art.model.Movement;
import com.algorist.art.model.brushes.parameters.Parameter;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Polygon;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;
import javax.swing.Timer;

/**
 *
 * @author alan.jbssa
 */
public class RB4_Brush extends Brush {
    
       public RB4_Brush() {
        name = "Vintage";
    }

    @Override
    public void initialize(Layer layer) {
    }

    @Override
    public void draw(Movement movement) {
        Graphics2D g = layer.getImage().createGraphics();
        // The thick line is in fact a filled polygon
        g.setColor(Color.BLACK);
        // line length
        double lineLength = Math.sqrt(movement.getDeltaX() * movement.getDeltaX() + movement.getDeltaY() * movement.getDeltaY());
        int thickness = 5;
        double scale = (double) (thickness) / (2 * lineLength);

        // The x,y increments from an endpoint needed to create a rectangle...
        double ddx = -scale * (double) movement.getDeltaY();
        double ddy = scale * (double) movement.getDeltaX();
        ddx += (ddx > 0) ? 0.5 : -0.5;
        ddy += (ddy > 0) ? 0.5 : -0.5;
        int dx = (int) ddx;
        int dy = (int) ddy;

        // Now we can compute the corner points...
        int xPoints[] = new int[4];
        int yPoints[] = new int[4];

        xPoints[0] = movement.getOldPosition().x + dx;
        yPoints[0] = movement.getOldPosition().y + dy;
        xPoints[1] = movement.getOldPosition().x - dx;
        yPoints[1] = movement.getOldPosition().y - dy;
        xPoints[2] = movement.getNewPosition().x - dx;
        yPoints[2] = movement.getNewPosition().y - dy;
        xPoints[3] = movement.getNewPosition().x + dx;
        yPoints[3] = movement.getNewPosition().y + dy;

        g.fillPolygon(xPoints, yPoints, 4);
    }

    @Override
    public void loadDefaultPresets() {
    }

    @Override
    public Map<String, Parameter> getParamTypes() {
        return null;
    }
}
