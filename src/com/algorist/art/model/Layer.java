/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.algorist.art.model;

import com.alanjhonnes.event.EventDispatcher;
import com.algorist.art.event.LayerEvent;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.WritableRaster;

/**
 *
 * @author alan.jbssa
 */
public class Layer extends EventDispatcher {

    private float opacity = 1;
    private BufferedImage image;
    private BufferedImage thumbnail;
    private int width;
    private int height;

    public Layer(int width, int height) {
        this.width = width;
        this.height = height;
        image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB_PRE);
        refreshThumbnail();
    }

    public Layer(BufferedImage image) {
        this.image = image;
        this.width = image.getWidth();
        this.height = image.getHeight();
        refreshThumbnail();
    }

    public void setSize(int width, int height) {
        ///
        dispatchEvent(new LayerEvent(this, LayerEvent.SIZE_CHANGED));
    }

    private void refreshThumbnail() {
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

    public BufferedImage getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(BufferedImage thumbnail) {
        this.thumbnail = thumbnail;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}
