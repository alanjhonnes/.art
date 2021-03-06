/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.algorist.art.view.display;

import com.alanjhonnes.event.CallbackFunction;
import com.alanjhonnes.event.Event;
import com.algorist.art.event.LayerEvent;
import com.algorist.art.model.Layer;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;

/**
 *
 * @author alan.jbssa
 */
public class LayerPanel extends JPanel {

    private Layer layer;

    public LayerPanel(final Layer layer) {
        super();
        this.layer = layer;
        this.setPreferredSize(new Dimension(layer.getWidth(), layer.getHeight()));
        layer.addEventListener(LayerEvent.SIZE_CHANGED, new CallbackFunction() {

            @Override
            public void execute(Event e) {
                setSize(layer.getWidth(), layer.getHeight());
                invalidate();
            }
        });
        
        layer.addEventListener(LayerEvent.IMAGE_CHANGED, new CallbackFunction() {

            @Override
            public void execute(Event e) {
                setSize(layer.getWidth(), layer.getHeight());
                invalidate();
                repaint();
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
	g2d.drawImage( layer.getImage(), null, 0,0);
    }

    public Layer getLayer() {
        return layer;
    }

    public void setLayer(Layer layer) {
        this.layer = layer;
    }
    
}
