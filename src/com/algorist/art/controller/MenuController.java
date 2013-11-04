/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.algorist.art.controller;

import com.algorist.art.model.Art;
import com.algorist.art.model.Document;
import com.thoughtworks.xstream.XStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.net.URLDecoder;
import java.nio.charset.Charset;
import java.util.logging.Level;
import java.util.logging.Logger;
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

    public void saveDocument() {
        Document doc = artModel.getCurrentDocument();
        String path = MenuController.class.getProtectionDomain().getCodeSource().getLocation().getPath();
        String absolutePath = "";
        try {
            absolutePath = URLDecoder.decode(path, "UTF-8");
            int lastSlash = absolutePath.lastIndexOf("/");
            absolutePath = absolutePath.substring(0, lastSlash + 1);
            System.out.println("Absolute path: " + absolutePath);
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(MenuController.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (artModel.getCurrentDocument() != null) {
            try {
                FileOutputStream fo = new FileOutputStream(absolutePath + doc.getName() + ".art");
                ObjectOutputStream oo = new ObjectOutputStream(fo);
                oo.writeObject(doc.getSerializableVersion()); // serializo objeto cat
                oo.close();
                System.out.println("Class Cat – object serializado com sucesso");
            } catch (Exception e) {
                e.printStackTrace();
            }
            //desserializo o objeto


        }
    }

    public void loadDocument() {
        String path = MenuController.class.getProtectionDomain().getCodeSource().getLocation().getPath();
        String absolutePath = "";
        try {
            absolutePath = URLDecoder.decode(path, "UTF-8");
            int lastSlash = absolutePath.lastIndexOf("/");
            absolutePath = absolutePath.substring(0, lastSlash + 1);
            System.out.println("Absolute path: " + absolutePath);
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(MenuController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            FileInputStream fi = new FileInputStream(absolutePath + "Novo documento.art");
            ObjectInputStream oi = new ObjectInputStream(fi);
            Document doc = (Document) oi.readObject();
            artModel.addDocument(doc);
            oi.close();
            System.out.println("agora ele foi des-serializado com sucesso");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
