/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.algorist.art.view.display;

import com.algorist.art.model.Layer;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
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
        super.paintComponent(g); //To change body of generated methods, choose Tools | Templates.
        System.out.println("Layer painted");
        this.setBackground(Color.yellow);
        g.setColor(Color.yellow);
        g.drawRect(50, 50, 50, 50);
        g.fillRect(50, 50, 50, 50);
        g.drawString("This is my custom Panel!",10,20);
        //g.drawImage(layer.getImage(), layer.getWidth(), layer.getHeight(), this);
    }
}
