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
import java.util.Map;

/**
 *
 * @author user
 */
public class SoftBrush extends Brush {

    @Override
    public void initialize(Layer layer) {
        
    }

    @Override
    public void draw(Movement movement) {
        Graphics2D g = (Graphics2D) layer.getImage().createGraphics();
        g.setColor(new Color(0f, 0f, 0f, 0.5f));
        float sizeX;
        float sizeY;
        //g.fillOval(movement.getNewPosition().x, movement.getNewPosition().y, movement.,5);
    }

    @Override
    public void loadDefaultPresets() {
        
    }

    @Override
    public Map<String, Parameter> getParamTypes() {
        return null;
    }
    
}
