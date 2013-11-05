/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.algorist.art.controller;

import com.alanjhonnes.event.CallbackFunction;
import com.alanjhonnes.event.Event;
import com.algorist.art.event.ArtEvent;
import com.algorist.art.model.Art;
import com.algorist.art.model.Movement;
import com.algorist.art.model.brushes.Brush;
import com.algorist.art.view.DrawingAreaView;
import com.algorist.art.view.display.LayerPanel;
import java.awt.Point;
import java.util.List;
import mvc.AbstractController;
import mvc.AbstractFrame;

/**
 *
 * @author alanjhonnes
 */
public class DrawingAreaController extends AbstractController {

    private DrawingAreaView view;
    private Brush brush;
    private Art artModel;
    private Movement movement;

    public DrawingAreaController(AbstractFrame mainFrame, Art art) {
        super(mainFrame);
        this.artModel = art;
        brush = art.getSelectedBrush();
        artModel.addEventListener(ArtEvent.BRUSH_CHANGED, new CallbackFunction() {
            @Override
            public void execute(Event e) {
                brush = artModel.getSelectedBrush();
                
            }
        });
        artModel.addEventListener(ArtEvent.MOVEMENT_STARTED, new CallbackFunction() {
            @Override
            public void execute(Event e) {
                ArtEvent ae = (ArtEvent) e;
                brush.initialize(artModel.getCurrentDocument().getSelectedLayer());
                brush.startDrawing(ae.getMovement(), artModel.getCurrentDocument().getSelectedLayer());
            }
        });
    }

    public void movementStarted(Point startPosition) {
        movement = new Movement(startPosition);
        artModel.startMovement(movement);
        System.out.println(movement);
    }

    public void movementUpdated(Point newPosition) {
        if (movement != null) {
            movement.movePosition(newPosition);
            List<LayerPanel> layerPanels = view.getLayerPanels();
            for (int i = 0; i < layerPanels.size(); i++) {
                LayerPanel layerPanel = layerPanels.get(i);
                layerPanel.repaint();
            }
            System.out.println(movement);
        }

    }

    public void movementEnded() {
        brush.stopDrawing(movement);
        artModel.endMovement(movement);
        movement = null;
    }

    public DrawingAreaView getView() {
        return view;
    }

    public void setView(DrawingAreaView view) {
        this.view = view;
    }
    
}
