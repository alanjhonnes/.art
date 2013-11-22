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
public class AddContext implements CompositeContext {

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
        
        int averageS, averageD, dif, max, srcP, dstP, sumS, sumD, srcA, dstA, outA;
        
        double ratioS, ratioD;

        for (int x = 0; x < w; x++) {
            for (int y = 0; y < h; y++) {
                src.getPixel(x, y, srcRgba);
                dstIn.getPixel(x, y, dstRgba);
                //System.out.println(srcRgba[0]);
                
                sumS = srcRgba[0] + srcRgba[1] + srcRgba[2];
                sumD = dstRgba[0] + dstRgba[1] + dstRgba[2];
                
                srcA = srcRgba[3];
                dstA = dstRgba[3];
                
                outA = Math.min(255, srcA + dstA * (255 - srcA));
                
                averageS = sumS / 3;
                averageD = sumD / 3;
                
                max = Math.max(srcRgba[0],srcRgba[1]);
                max = Math.max(max, srcRgba[2]);
                
                //System.out.println(dstRgba[0] + ", " + dstRgba[1] + ", " + dstRgba[2] + ", " + dstRgba[3] );
                for (int i = 0; i < 3; i++) {
                    dstP = dstRgba[i];
                    srcP = srcRgba[i];
                    
                    
                    //100%   -  sumS
                    //ratioS -  srcP
                    //sumS * ratioS = 100 * srcP
                    //ratioS = 100*srcP 
                    
                    //ratioS = 100 * srcP / sumS
//                    ratioS = srcP / sumS;
//                    ratioD = sumD / dstP;
//                    
//                    dif = averageS - dstP;
                    
                    value = (srcP * srcA + dstP * dstA * (255 - srcA)) / (outA);
                    
                    //value = Math.min(255, value);
                    //value = srcP;
                     resultRgba[i] = value;
                    //resultRgba[i] = average;
                    //resultRgba[i] = (int) (Math.random() * 255);
                    
                }
                
                resultRgba[3] = outA;
                //System.out.println(resultRgba[0] + ", " + resultRgba[1] + ", " + resultRgba[2] + ", " + resultRgba[3]);
                
//                for (int i = 0; i < 3; i++) {
////                    value = srcRgba[i] + dstRgba[i];
////                    value = srcRgba[i];
////                    value = (int) (srcRgba[i] + (1-Math.pow(2, -dstRgba[i]*0.005))*255);
//                    //value = (int) (srcRgba[i] + dstRgba[i]) / 2;
//                    value = (int) (255 - (255 - srcRgba[i]) * (255 - dstRgba[i]));
////                    value = (int) (Math.random() * 255);
////                    if(value > 255){
////                        value = 255;
////                    }
//                    resultRgba[i] = value;
//                    //System.out.println(value);
//                }
                dstOut.setPixel(x, y, resultRgba);
            }
        }
    }
    
}
