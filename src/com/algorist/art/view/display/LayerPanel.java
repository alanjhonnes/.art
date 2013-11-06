/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.algorist.art.view.display;

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

    public LayerPanel(Layer layer) {
        super();
        this.layer = layer;
        this.setPreferredSize(new Dimension(layer.getWidth(), layer.getHeight()));
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
