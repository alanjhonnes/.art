/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.algorist.art.view;

import com.alanjhonnes.event.CallbackFunction;
import com.alanjhonnes.event.Event;
import com.algorist.art.controller.DocumentsController;
import com.algorist.art.controller.DocumentController;
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
    private List<DocumentView> documentViews;

    public DocumentsView(AbstractFrame mainFrame, Art artModel, DocumentsController controller) {
        super(mainFrame);
        this.artModel = artModel;
        this.controller = controller;
        documentViews = new ArrayList<>();
        controller.setView(this);

        contentPane.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                if (documentViews.size() > 0) {
                    Document doc = documentViews.get(contentPane.getSelectedIndex()).getDocumentModel();
                    getController().currentDocumentChanged(doc);
                }
            }
        });

        artModel.addEventListener(ArtEvent.DOCUMENT_ADDED, new CallbackFunction() {
            @Override
            public void execute(Event e) {
                ArtEvent ae = (ArtEvent) e;

                Document doc = ae.getDocument();
                DocumentView dwa = new DocumentView(getMainFrame(), new DocumentController(getMainFrame(), getArtModel()), doc);
                documentViews.add(dwa);
                contentPane.add(doc.getName(), dwa.getContentPane());
                contentPane.setSelectedIndex(documentViews.size() - 1);
            }
        });

        artModel.addEventListener(ArtEvent.DOCUMENT_REMOVED, new CallbackFunction() {
            @Override
            public void execute(Event e) {
                ArtEvent ae = (ArtEvent) e;
                Document doc = ae.getDocument();
                DocumentView dv;
                for (int i = 0; i < documentViews.size(); i++) {
                    DocumentView documentView = documentViews.get(i);
                    if (documentView.getDocumentModel() == doc) {
                        dv = documentView;
                        documentViews.remove(dv);
                        contentPane.remove(dv.getContentPane());
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
            DocumentView dv = new DocumentView(getMainFrame(), new DocumentController(getMainFrame(), getArtModel()), document);
            documentViews.add(dv);
            contentPane.add(document.getName(), dv.getContentPane());
        }
    }

    public DocumentsController getController() {
        return controller;
    }

    public List<DocumentView> getDrawingAreaViews() {
        return documentViews;
    }
}
