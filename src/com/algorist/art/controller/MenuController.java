/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.algorist.art.controller;

import com.algorist.art.FileManager;
import com.algorist.art.model.Art;
import com.algorist.art.model.Document;
import com.sun.jnlp.FileOpenServiceImpl;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jnlp.FileContents;
import javax.jnlp.FileOpenService;
import javax.jnlp.ServiceManager;
import javax.jnlp.UnavailableServiceException;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import mvc.AbstractController;
import mvc.AbstractFrame;

/**
 *
 * @author alanjhonnes
 */
public class MenuController extends AbstractController {

    private Art artModel;

    public MenuController(AbstractFrame mainFrame, Art artModel) {
        super(mainFrame);
        this.artModel = artModel;
    }

    public void newDocument() {
        int i = artModel.getDocuments().size() + 1;
        Document doc = new Document("Novo documento " + i, 600, 500);
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
}
