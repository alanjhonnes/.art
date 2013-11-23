/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.algorist.art.model;

import com.alanjhonnes.event.EventDispatcher;
import com.algorist.art.event.LayerEvent;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.WritableRaster;
import java.io.File;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import javax.imageio.ImageIO;

/**
 *
 * @author alan.jbssa
 */
public class Layer extends EventDispatcher implements Serializable {

    private float opacity = 1;
    transient private BufferedImage image;
    //private BufferedImage thumbnail;
    private int width;
    private int height;

    public Layer(int width, int height) {
        this.width = width;
        this.height = height;
        image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g = image.createGraphics();
//        g.setColor(Color.WHITE);
//        g.fillRect(0, 0, width / 2, height / 2);
//
//        g.setColor(Color.black);
//        g.fillRect(width / 2, 0, width / 2, height / 2);
//
//        g.setColor(Color.blue);
//        g.fillRect(0, height / 2, width / 2, height / 2);
//
//        g.setColor(Color.red);
//        g.fillRect(width / 2, height / 2, width / 2, height / 2);
        
//        g.setColor(Color.black);
//        g.fillRect(0, 0, width, height);
        //refreshThumbnail();
    }

    public Layer(BufferedImage image) {
        this.image = image;
        this.width = image.getWidth();
        this.height = image.getHeight();
        //refreshThumbnail();
    }

    public void setSize(int width, int height) {
        BufferedImage newImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);

        Graphics2D g = newImage.createGraphics();
        g.drawImage(image, 0, 0, image.getWidth(), image.getHeight(), null);
        g.dispose();
        image.flush();
        image = newImage;
        this.width = width;
        this.height = height;
        System.out.println("Layer resized: " + this.width + ", " + this.height);
        dispatchEvent(new LayerEvent(this, LayerEvent.SIZE_CHANGED));
    }

    public Layer duplicate() {
        ColorModel cm = image.getColorModel();
        boolean isAlphaPremultiplied = cm.isAlphaPremultiplied();
        WritableRaster raster = image.copyData(null);
        return new Layer(new BufferedImage(cm, raster, isAlphaPremultiplied, null));
    }

    public float getOpacity() {
        return opacity;
    }

    public void setOpacity(float opacity) {
        this.opacity = opacity;
    }

    public BufferedImage getImage() {
        return image;
    }

    public void setImage(BufferedImage image) {
        this.image = image;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();
        ImageIO.write(image, "png", out); // png is lossless
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        image = ImageIO.read(in);
    }

    public void clear() {
        Graphics2D g = image.createGraphics();
        g.setBackground(new Color(1f, 1f, 1f, 1f));
        g.clearRect(0, 0, image.getWidth(), image.getHeight());
        dispatchEvent(new LayerEvent(this, LayerEvent.IMAGE_CHANGED));
    }
}
