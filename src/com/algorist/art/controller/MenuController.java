/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.algorist.art.controller;

import com.algorist.art.util.FileManager;
import com.algorist.art.model.Art;
import com.algorist.art.model.Document;
import com.algorist.art.model.Movement;
import com.algorist.art.util.FluidMovement;
import com.algorist.art.view.DocumentsView;
import java.awt.Point;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTabbedPane;
import mvc.AbstractController;
import mvc.AbstractFrame;

/**
 *
 * @author alanjhonnes
 */
public class MenuController extends AbstractController {

    private Art artModel;
    
    private List<FluidMovement> fluidMovements = new ArrayList<>();

    public MenuController(AbstractFrame mainFrame, Art artModel) {
        super(mainFrame);
        this.artModel = artModel;
    }

    public void newDocument() {
        int i = artModel.getDocuments().size() + 1;
        JTabbedPane documentPanel = getMainFrame().getView(DocumentsView.class).getContentPane();
        Document doc = new Document("Novo documento " + i, documentPanel.getWidth(), documentPanel.getHeight());
        artModel.addDocument(doc);
    }

    public void closeDocument() {
        artModel.removeDocument(artModel.getCurrentDocument());
    }

    public void saveDocument(String path) {
        Document doc = artModel.getCurrentDocument();
        if (doc != null) {
            FileManager.saveFile(doc.getSerializableVersion(), path);
        }
    }

    public void loadDocument(File documentFile) {
        try {
            ObjectInputStream oi = new ObjectInputStream(new FileInputStream(documentFile));
            Document doc;
            try {
                doc = (Document) oi.readObject();
                artModel.addDocument(doc);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(MenuController.class.getName()).log(Level.SEVERE, null, ex);
            }

            oi.close();
        } catch (IOException ex) {
            Logger.getLogger(MenuController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void addLayer() {
        artModel.getCurrentDocument().addLayer();
    }

    public void cleanLayer() {
        artModel.getCurrentDocument().getSelectedLayer().clear();
    }

    public void startMovement() {
        Document doc = artModel.getCurrentDocument();
        Movement movement = new Movement(new Point( (int) (Math.random() * doc.getWidth()), (int) (Math.random() * doc.getHeight())));
        artModel.startMovement(movement);
        Point startPoint = new Point((int) (Math.random() * doc.getWidth()), (int) (Math.random() * doc.getHeight()));
        FluidMovement fluidMovement = new FluidMovement(movement, startPoint, Math.random() * 8 + 5, 0.03, 10, 1500, doc.getWidth(), doc.getHeight());
        fluidMovements.add(fluidMovement);
    }

    public void stopMovements() {
        List<Movement> movements = artModel.getMovements();
        
        for (int i = 0; i < fluidMovements.size(); i++) {
            FluidMovement fluidMovement = fluidMovements.get(i);
            fluidMovement.dispose();
        }
        
        fluidMovements.clear();
        
        List<Movement> movementsToRemove = new ArrayList<>();
        
        for (int i = 0; i < movements.size(); i++) {
            Movement movement = movements.get(i);
            movementsToRemove.add(movement);
        }
        
        for (int i = 0; i < movementsToRemove.size(); i++) {
            Movement movement = movementsToRemove.get(i);
            artModel.endMovement(movement);
        }
        
        movementsToRemove.clear();
    }
}
