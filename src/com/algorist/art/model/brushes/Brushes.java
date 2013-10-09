/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.algorist.art.model.brushes;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

/**
 *
 * @author senac2012
 */
public class Brushes extends Observable {
    
    private List<Brush> brushes;

    public Brushes() {
        brushes = new ArrayList<>();
        brushes.add(new CirclesBrush());
        brushes.add(new LinesBrush());
    }

    public Brushes(List<Brush> brushes) {
        this.brushes = brushes;
    }
    
}
