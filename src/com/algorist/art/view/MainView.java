/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.algorist.art.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**
 *
 * @author alan.jbssa
 */
public class MainView extends JFrame implements Observer {
    
    public MenuView menu;
    
    public JScrollPane drawingContainer;
    public JPanel drawingArea;

    public MainView() {
        this.setTitle(".art");
        this.setLayout(new BorderLayout());
        setMinimumSize(new Dimension(500, 400));
        //menu = new MenuView();
        //setJMenuBar(menu);
        
        drawingArea = new JPanel();
        drawingContainer = new JScrollPane(drawingArea);
        
        this.add(drawingContainer);
        
        
    }

    @Override
    public void update(Observable o, Object o1) {

    }

    
    
    
    
}
