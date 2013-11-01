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
import java.awt.Color;
import java.awt.Graphics2D;
import java.util.Map;

/**
 *
 * @author alan.jbssa
 */
public class LinesBrush extends Brush {

    public LinesBrush() {
        super();
        this.name = "Linhas";
        drawCallback = new CallbackFunction() {

            @Override
            public void execute(Event e) {
                MovementEvent me = (MovementEvent) e;
                Movement movement = (Movement) e.getSource();
                Graphics2D g = (Graphics2D) layer.getImage().createGraphics();
                g.setColor(Color.BLACK);
                g.drawLine(movement.getOldPosition().x, movement.getOldPosition().y, movement.getNewPosition().x, movement.getNewPosition().y);
                
            }
        };
    }

    @Override
    public void loadDefaultPresets() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Map<String, Parameter> getParamTypes() {
        return null;
    }

    @Override
    public void initialize() {
    }

    @Override
    public void draw() {
    }

    
    
}
