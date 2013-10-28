/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.algorist.art.view;

import com.algorist.art.controller.DrawingAreaController;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import mvc.AbstractFrame;
import mvc.AbstractView;

/**
 *
 * @author senac2012
 */
public class DrawingAreaView  extends AbstractView<JLayeredPane> { 

    private DrawingAreaController controller;
    
    public DrawingAreaView(AbstractFrame mainFrame) {
        super(mainFrame);
        controller = mainFrame.getController(DrawingAreaController.class);
    }

    @Override
    protected JLayeredPane layout() {
        JLayeredPane panel = new JLayeredPane();
        panel.setPreferredSize(new Dimension(600, 500));
        panel.addMouseListener(null);
        
        return panel;
    }
    
    MouseListener mouseListener = new MouseAdapter()
    {
        @Override
        public void mousePressed( MouseEvent e )
        {
            if ( e.getButton() == MouseEvent.BUTTON1 )
            {
                controller.onMousePressed();
            }
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            if ( e.getButton() == MouseEvent.BUTTON1 )
            {
                controller.onMouseReleased();
            }
        }
        
        
    };
    
    MouseMotionListener mouseMotionListener = new MouseMotionListener()
    {
        @Override
        public void mouseDragged( MouseEvent e )
        {
        }

        @Override
        public void mouseMoved( MouseEvent e )
        {
            controller.onMouseMoved(e.getPoint());
        }
    };
    
    
    
    
    
}
