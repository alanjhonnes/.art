/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.algorist.art.controller;

import com.algorist.art.model.Document;
import com.algorist.art.view.ExportView;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import mvc.AbstractController;
import mvc.AbstractFrame;

/**
 *
 * @author Asus
 */
public class ExportController extends AbstractController {

    private Document model;
    private ExportView view;

    public ExportController(AbstractFrame mainFrame, Document documentModel) {
        super(mainFrame);
        this.model = documentModel;
    }

    public void saveGIF(String caminhoSalvar) {
        //Salva a imagem em disco  
        File file = new File(caminhoSalvar + ".gif");
        try {
            ImageIO.write(model.getResultingImage(), "gif", file);
            view.showMessage("Arquivo salvo em: " + file.getAbsolutePath());
        } catch (IOException ex) {
            view.showMessage("Erro salvando arquivo em: " + file.getAbsolutePath());
            Logger.getLogger(ExportController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void saveJPG(String caminhoSalvar, int quality) {
        //Salva a imagem em disco  
        File file = new File(caminhoSalvar + ".jpg");
        try {
            BufferedImage bufferedImage = model.getResultingImage();
             BufferedImage imageRGB = new BufferedImage(bufferedImage.getWidth(), bufferedImage.getHeight(), BufferedImage.TYPE_INT_RGB);
            for (int i = 0; i < bufferedImage.getWidth(); i++) {
                for (int j = 0; j < bufferedImage.getHeight(); j++) {
                    bufferedImage.getRGB(i, j);
                    imageRGB.setRGB(i, j, bufferedImage.getRGB(i, j));
                }
            }
             
             
             
             
            ImageIO.write(imageRGB, "jpg", file);
            view.showMessage("Arquivo salvo em: " + file.getAbsolutePath());
        } catch (IOException ex) {
            view.showMessage("Erro salvando arquivo em: " + file.getAbsolutePath());
            Logger.getLogger(ExportController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void savePNG(String caminhoSalvar) {
        //Salva a imagem em disco  
        File file = new File(caminhoSalvar + ".png");
        try {
            ImageIO.write(model.getResultingImage(), "png", file);
            view.showMessage("Arquivo salvo em: " + file.getAbsolutePath());
        } catch (IOException ex) {
            view.showMessage("Erro salvando arquivo em: " + file.getAbsolutePath());
            Logger.getLogger(ExportController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ExportView getView() {
        return view;
    }

    public void setView(ExportView view) {
        this.view = view;
    }

}
