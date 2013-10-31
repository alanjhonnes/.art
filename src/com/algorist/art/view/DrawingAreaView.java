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
import javax.swing.JLayeredPane;
import mvc.AbstractFrame;
import mvc.AbstractView;

/**
 *
 * @author senac2012
 */
public class DrawingAreaView extends AbstractView<JLayeredPane> {

    private DrawingAreaController controller;
    private MouseListener mouseListener;
    private MouseMotionListener mouseMotionListener;

    public DrawingAreaView(AbstractFrame mainFrame, DrawingAreaController controller) {
        super(mainFrame);
        this.controller = controller;
    }

    @Override
    protected JLayeredPane layout() {
        JLayeredPane panel = new JLayeredPane();
        panel.setPreferredSize(new Dimension(600, 500));

        mouseListener = new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if (e.getButton() == MouseEvent.BUTTON1) {
                    controller.onMousePressed();
                }
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                if (e.getButton() == MouseEvent.BUTTON1) {
                    controller.onMouseReleased();
                }
            }
        };

        mouseMotionListener = new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent e) {
            }

            @Override
            public void mouseMoved(MouseEvent e) {
                controller.onMouseMoved(e.getPoint());
            }
        };

        panel.addMouseListener(mouseListener);
        panel.addMouseMotionListener(mouseMotionListener);
        return panel;
    }
}
