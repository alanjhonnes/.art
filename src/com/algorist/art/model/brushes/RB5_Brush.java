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
public class RB5_Brush extends Brush {

    @Override
    public void initialize(Layer layer) {
    }

    @Override
    public void draw(Movement movement) {
        double x, y, tempx,tempy;
        Graphics2D g = layer.getImage().createGraphics();
        g.setColor(Color.ORANGE);
		
		for (int i = 0; i < 35; i++){
			// use static final ints now
			tempx = (x + (int) Math.round(2 * SMALL_OFFSET * (Math.random() -0.5)));
			tempy = (y + (int) ( ((Math.random()-0.5)*2) * Math.sqrt(
				(SMALL_OFFSET * SMALL_OFFSET) - ((x - tempx) * (x - tempx)))));
			g.drawLine(tempx, tempy, tempx, tempy);
		}
		
		for (int i = 0; i < 12; i++){
			tempx = (x + (int) Math.round( 2* BIG_OFFSET*(Math.random() -0.5)));
			tempy = (y + (int) ( ((Math.random()-0.5)*2) * Math.sqrt(
				(BIG_OFFSET * BIG_OFFSET) - ((x - tempx) * (x - tempx)))));
			g.drawLine(tempx, tempy, tempx, tempy);
		}
		re paint();
    }

    @Override
    public void loadDefaultPresets() {
    }

    @Override
    public Map<String, Parameter> getParamTypes() {
        return null;
    }
}
