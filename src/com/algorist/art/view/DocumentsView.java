/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.algorist.art.view;

import com.alanjhonnes.event.CallbackFunction;
import com.alanjhonnes.event.Event;
import com.algorist.art.controller.DocumentsController;
import com.algorist.art.controller.DrawingAreaController;
import com.algorist.art.event.ArtEvent;
import com.algorist.art.model.Art;
import com.algorist.art.model.Document;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JTabbedPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import mvc.AbstractFrame;
import mvc.AbstractView;

/**
 *
 * @author alan.jbssa
 */
public class DocumentsView extends AbstractView<JTabbedPane> {

    private Art artModel;
    private DocumentsController controller;
    private List<DrawingAreaView> drawingAreaViews;

    public DocumentsView(AbstractFrame mainFrame, Art artModel, DocumentsController controller) {
        super(mainFrame);
        this.artModel = artModel;
        this.controller = controller;
        drawingAreaViews = new ArrayList<>();
        controller.setView(this);
        
        contentPane.addChangeListener(new ChangeListener() {

            @Override
            public void stateChanged(ChangeEvent e) {
                
                Document doc = drawingAreaViews.get(contentPane.getSelectedIndex()).getDocumentModel();
                getController().currentDocumentChanged(doc);
            }
        });

        artModel.addEventListener(ArtEvent.DOCUMENT_ADDED, new CallbackFunction() {
            @Override
            public void execute(Event e) {
                ArtEvent ae = (ArtEvent) e;
                
                Document doc = ae.getDocument();
                DrawingAreaView dwa = new DrawingAreaView(getMainFrame(), new DrawingAreaController(getMainFrame(), getArtModel()), doc);
                drawingAreaViews.add(dwa);
                contentPane.add(doc.getName(), dwa.getContentPane());
                contentPane.setSelectedIndex(drawingAreaViews.size()-1);
            }
        });

        artModel.addEventListener(ArtEvent.DOCUMENT_REMOVED, new CallbackFunction() {
            @Override
            public void execute(Event e) {
                ArtEvent ae = (ArtEvent) e;
                Document doc = ae.getDocument();
                DrawingAreaView dwa;
                for (int i = 0; i < drawingAreaViews.size(); i++) {
                    DrawingAreaView drawingAreaView = drawingAreaViews.get(i);
                    if (drawingAreaView.getDocumentModel() == doc) {
                        dwa = drawingAreaView;
                        drawingAreaViews.remove(dwa);
                        contentPane.remove(dwa.getContentPane());
                        contentPane.invalidate();
                        contentPane.revalidate();
                        contentPane.repaint();
                        break;
                    }
                }
            }
        });

        setupPanels();

    }

    @Override
    protected JTabbedPane layout() {
        JTabbedPane tabbedPane = new JTabbedPane();
        return tabbedPane;
    }

    public Art getArtModel() {
        return artModel;
    }

    private void setupPanels() {
        List<Document> docs = artModel.getDocuments();
        for (int i = 0; i < docs.size(); i++) {
            Document document = docs.get(i);
            DrawingAreaView dwa = new DrawingAreaView(getMainFrame(), new DrawingAreaController(getMainFrame(), getArtModel()), document);
            drawingAreaViews.add(dwa);
            contentPane.add(document.getName(), dwa.getContentPane());
        }
    }

    public DocumentsController getController() {
        return controller;
    }

    public List<DrawingAreaView> getDrawingAreaViews() {
        return drawingAreaViews;
    }
}
