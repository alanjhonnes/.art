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
import java.awt.Point;
import mvc.AbstractController;
import mvc.AbstractFrame;

/**
 *
 * @author senac2012
 */
public class DrawingAreaController extends AbstractController {

    public Point mousePosition;
    private DrawingAreaView view;
    private Brush brush;
    private Art model;
    
    private Movement mouseMovement;
    
    public DrawingAreaController(AbstractFrame mainFrame, Art artModel) {
        super(mainFrame);
        view = mainFrame.getView(DrawingAreaView.class);
        model = artModel;
        model.addEventListener(ArtEvent.BRUSH_CHANGED, new CallbackFunction() {
            @Override
            public void execute(Event e) {
                brush = model.getSelectedBrush();
            }
        });
        model.addEventListener(ArtEvent.MOVEMENT_STARTED, new CallbackFunction() {
            @Override
            public void execute(Event e) {
                ArtEvent ae = (ArtEvent) e;
                brush.startDrawing(ae.getMovement(), model.getCurrentDocument().getSelectedLayer());
            }
        });
    }
    
    public void onMousePressed(){
        Movement movement = new Movement(mousePosition);
        model.startMovement(movement);
    }
    
    public void onMouseMoved(Point newMousePosition){
        mousePosition = newMousePosition;
        System.out.println(mousePosition);
    }
    
    public void onMouseReleased(){
        brush.stopDrawing();
    }
    
    
    
    
}
