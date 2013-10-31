/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.algorist.art.model;

import java.awt.Point;

/**
 *
 * @author Wellington
 */
public class Movement {
    private Point startPosition;
    private Point oldPosition;
    private Point newPosition;
    private int deltaX;
    private int deltaY;
    private double angle;

    public Movement(Point startPosition) {
        this.startPosition = startPosition;
        this.oldPosition = new Point(startPosition);
        this.newPosition = new Point(startPosition);
    }
    
    public void movePosition(Point newPosition){
        this.oldPosition = this.newPosition;
        this.newPosition = newPosition;
        
        deltaX = newPosition.x - oldPosition.x;
        deltaY = newPosition.y - oldPosition.y;
        
        this.angle = Math.atan2(deltaY, deltaX) * 180 / Math.PI;
    }
    
    
    
    
    
}
