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
import com.algorist.art.model.Document;
import com.algorist.art.model.Movement;
import com.algorist.art.model.brushes.Brush;
import com.algorist.art.view.DocumentView;
import com.algorist.art.view.display.LayerPanel;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.Timer;
import mvc.AbstractController;
import mvc.AbstractFrame;

/**
 *
 * @author alanjhonnes
 */
public class DocumentController extends AbstractController {

    private DocumentView view;
    private Brush brush;
    private Art artModel;
    private Document documentModel;
    private Movement mouseMovement;
    private List<Movement> movements;
    private CallbackFunction movementTickCallback;
    private CallbackFunction brushChangedCallback;
    private CallbackFunction movementStartedCallback;
    private CallbackFunction movementEndedCallback;
    private CallbackFunction documentChangedCallback;
    
    private boolean activeDocument = false;
    
    private Timer redrawTimer;
    private ActionListener redrawListener;

    public DocumentController(AbstractFrame mainFrame, Art art, Document document) {
        super(mainFrame);
        this.artModel = art;
        this.movements = new ArrayList<>();
        this.documentModel = document;
        brush = art.getSelectedBrush();
        
        redrawListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateView();
            }
        };
        redrawTimer = new Timer(16, redrawListener);

        movementTickCallback = new CallbackFunction() {
            @Override
            public void execute(Event e) {
                MovementEvent me = (MovementEvent) e;
                Movement mov = (Movement) me.getSource();
                movementTick(mov);
            }
        };

        movementStartedCallback = new CallbackFunction() {
            @Override
            public void execute(Event e) {
                ArtEvent ae = (ArtEvent) e;
                brush.startDrawing(ae.getMovement(), artModel.getCurrentDocument().getSelectedLayer());
                ae.getMovement().addEventListener(MovementEvent.TIMER_TICK, movementTickCallback);
            }
        };

        movementEndedCallback = new CallbackFunction() {
            @Override
            public void execute(Event e) {
                ArtEvent ae = (ArtEvent) e;
                movementEnded(ae.getMovement());
            }
        };

        brushChangedCallback = new CallbackFunction() {
            @Override
            public void execute(Event e) {
                brush = artModel.getSelectedBrush();
                brush.initialize(artModel.getCurrentDocument().getWidth(), artModel.getCurrentDocument().getHeight());
            }
        };
        
        documentChangedCallback = new CallbackFunction() {
            @Override
            public void execute(Event e) {
                ArtEvent ae = (ArtEvent) e;
                if(ae.getDocument() == documentModel){
                    activeDocument = true;
                    artModel.addEventListener(ArtEvent.MOVEMENT_STARTED, movementStartedCallback);
                    redrawTimer.start();
                }
                else {
                    activeDocument = false;
                    redrawTimer.stop();
                    artModel.removeEventListener(ArtEvent.MOVEMENT_STARTED, movementStartedCallback);
                }
            }
        };
        
        
        
        artModel.addEventListener(ArtEvent.DOCUMENT_CHANGED, documentChangedCallback);
        artModel.addEventListener(ArtEvent.BRUSH_CHANGED, brushChangedCallback);
        artModel.addEventListener(ArtEvent.MOVEMENT_ENDED, movementEndedCallback);
    }

    public void mouseMovementStarted(Point startPosition) {
        mouseMovement = new Movement(startPosition);
        artModel.startMovement(mouseMovement);
        movements.add(mouseMovement);
    }

    public void mouseMovementUpdated(Point newPosition) {
        if (mouseMovement != null) {
            mouseMovement.movePosition(newPosition);
            //updateView();
        }
    }

    public void movementTick(Movement mov) {
        updateView();
    }
    
    public void updateView(){
        view.updateLayer(documentModel.getSelectedLayer());
    }

    private void movementEnded(Movement movement) {
        brush.stopDrawing(movement);
        //artModel.endMovement(movement);
        movements.remove(movement);
    }

    public void mouseMovementEnded() {
        brush.stopDrawing(mouseMovement);
        artModel.endMovement(mouseMovement);
        movements.remove(mouseMovement);
        mouseMovement = null;
    }

    public DocumentView getView() {
        return view;
    }

    public void setView(DocumentView view) {
        this.view = view;
    }

    public void dispose() {
        artModel.removeEventListener(ArtEvent.MOVEMENT_STARTED, movementStartedCallback);
        artModel.removeEventListener(ArtEvent.BRUSH_CHANGED, brushChangedCallback);
    }
}
