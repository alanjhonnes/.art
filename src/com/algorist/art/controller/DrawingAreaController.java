/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.algorist.art.controller;

import com.alanjhonnes.event.CallbackFunction;
import com.alanjhonnes.event.Event;
import com.algorist.art.event.ArtEvent;
import com.algorist.art.event.MovementEvent;
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
    
    private CallbackFunction movementTickCallback;

    public DrawingAreaController(AbstractFrame mainFrame, Art art) {
        super(mainFrame);
        this.artModel = art;
        brush = art.getSelectedBrush();
        
        movementTickCallback = new CallbackFunction() {
            @Override
            public void execute(Event e) {
                MovementEvent me = (MovementEvent) e;
                Movement mov = (Movement) me.getSource();
                movementTick(mov);
            }
        };
        
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
                ae.getMovement().addEventListener(MovementEvent.TIMER_TICK, movementTickCallback);
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
            view.updateLayer(artModel.getCurrentDocument().getSelectedLayer());
            //System.out.println(movement);
        }
    }
    
    public void movementTick(Movement mov){
        view.updateLayer(artModel.getCurrentDocument().getSelectedLayer());
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
