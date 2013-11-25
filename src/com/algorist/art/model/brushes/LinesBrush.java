/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.algorist.art.model.brushes;

import com.algorist.art.model.Layer;
import com.algorist.art.model.Movement;
import java.awt.Color;
import java.awt.Graphics2D;

/**
 *
 * @author alan.jbssa
 */
public class LinesBrush extends Brush {

    public LinesBrush() {
        super();
        this.name = "Linhas";
    }

    @Override
    public void draw(Movement movement) {
        Graphics2D g = (Graphics2D) layer.getImage().createGraphics();
        g.setColor(Color.BLACK);
        g.drawLine(movement.getOldPosition().x, movement.getOldPosition().y, movement.getNewPosition().x, movement.getNewPosition().y);
    }

    @Override
    public void loadDefaultPresets() {
        
    }

}
