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
public class ArcBrush extends Brush {

    public ArcBrush() {
        name = "ArcBrush";
    }

    @Override
    public void initialize(Layer layer) {

    }

    @Override
    public void draw(Movement movement) {
//        Graphics2D g = layer.getImage().createGraphics();
//        g.setColor(Color.CYAN);
//        g.drawArc(movement.getNewPosition().x, movement.getNewPosition().y, 10, 20, 0, (int) movement.getAngle());
    }

    @Override
    public void startDrawing(final Movement movement, Layer layer) {
        super.startDrawing(movement, layer);
        final Graphics2D g = layer.getImage().createGraphics();
        g.setColor(Color.CYAN);
        g.drawArc(movement.getNewPosition().x, movement.getNewPosition().y, 10, 20, 0, (int) 50);
        Timer timer = new Timer(20, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                g.drawArc(movement.getNewPosition().x, movement.getNewPosition().y, (int) Math.random() * 10, 20, 0, (int) Math.random() * 180);
            }
        });
        timer.start();

    }

    @Override
    public void loadDefaultPresets() {

    }

    @Override
    public Map<String, Parameter> getParamTypes() {
        return null;
    }

}
