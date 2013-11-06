/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alanjhonnes.graphics.composition;

import java.awt.CompositeContext;
import java.awt.image.Raster;
import java.awt.image.WritableRaster;

/**
 *
 * @author alan.jbssa
 */
public class LightenContext implements CompositeContext {

    @Override
    public void dispose() {
        
    }

    @Override
    public void compose(Raster src, Raster dstIn, WritableRaster dstOut) {
        
        int w = Math.min(src.getWidth(), dstIn.getWidth());
        int h = Math.min(src.getHeight(), dstIn.getHeight());

        int[] srcRgba = new int[4];
        int[] dstRgba = new int[4];
        
        int[] resultRgba = new int[4];
        
        int value;

        for (int x = 0; x < w; x++) {
            for (int y = 0; y < h; y++) {
                src.getPixel(x, y, srcRgba);
                dstIn.getPixel(x, y, dstRgba);
                for (int i = 0; i < 2; i++) {
                    value = srcRgba[i] + dstRgba[i];
                    value = 255 - (255 - srcRgba[i]) * (255 - dstRgba[i]);
                    if(value > 255){
                        value = 255;
                    }
                    resultRgba[i] = value;
                }
                resultRgba[3] = 255;
                dstOut.setPixel(x, y, resultRgba);
            }
        }
    }
    
}
