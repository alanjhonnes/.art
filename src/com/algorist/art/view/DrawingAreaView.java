/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.algorist.art.view;

import java.awt.Dimension;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JPanel;
import mvc.AbstractFrame;
import mvc.AbstractView;

/**
 *
 * @author senac2012
 */
public class DrawingAreaView  extends AbstractView<JPanel> implements Observer { 

    public DrawingAreaView(AbstractFrame mainFrame) {
        super(mainFrame);
    }

    @Override
    protected JPanel layout() {
        JPanel panel = new JPanel();
        panel.setPreferredSize(new Dimension(600, 500));
        return panel;
    }

    @Override
    public void update(Observable o, Object o1) {

    }
    
    
    
}
