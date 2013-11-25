/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.algorist.art.util;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Utility class to save files.
 * @author user
 */
public class FileManager {

    private static String absolutePath;

    public static void initialize() {
        String path = FileManager.class.getProtectionDomain().getCodeSource().getLocation().getPath();
        try {
            absolutePath = URLDecoder.decode(path, "UTF-8");
            int lastSlash = absolutePath.lastIndexOf("/");
            absolutePath = absolutePath.substring(0, lastSlash + 1);
            System.out.println("Absolute path: " + absolutePath);
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(FileManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void saveFile(Object object, String path) {
        try {
            FileOutputStream fo = new FileOutputStream(path);
            ObjectOutputStream oo = new ObjectOutputStream(fo);
            oo.writeObject(object);
            oo.close();
        } catch (IOException ex) {
            Logger.getLogger(FileManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void saveXML(Object object, String path) {
        
    }

    public static String getAbsolutePath() {
        return absolutePath;
    }
}
