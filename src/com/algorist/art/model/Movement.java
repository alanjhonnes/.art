/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.algorist.art.model;

import com.alanjhonnes.event.EventDispatcher;
import com.algorist.art.event.MovementEvent;
import java.awt.Point;

/**
 * Represents a movement used by the brushes to draw. It takes a position
 * and moves to another position, calculation its speed, angle and velocity 
 * automatically.
 * It is meant to abstract the mouse and touch behavior, while also allowing
 * movements to be created and manipulated by different algorithms without the 
 * need of user input to draw.
 * @author alanjhonnes
 */
public class Movement extends EventDispatcher {

    private Point startPosition;
    private Point oldPosition;
    private Point newPosition;
    private int deltaX;
    private int deltaY;
    private double velocityX;
    private double velocityY;
    private double speed;
    private double angle;
    private long startTime;
    public double rotation;

    public Movement(Point startPosition) {
        this.startPosition = startPosition;
        this.oldPosition = new Point(startPosition);
        this.newPosition = new Point(startPosition);
        startTime = System.currentTimeMillis();
    }

    /**
     * Moves the movement to a new position, calculation its speed, angle and velocity 
 * automatically in relation to its previous position.
     * @param newPosition The position the movement will move to.
     */
    public void movePosition(Point newPosition) {
        this.oldPosition = this.newPosition;
        this.newPosition = newPosition;

        deltaX = newPosition.x - oldPosition.x;
        deltaY = newPosition.y - oldPosition.y;

        //this.angle = Math.atan2(deltaY, deltaX) * 180 / Math.PI;
        this.angle = Math.atan2(deltaY, deltaX);
        //this.angle = Math.atan2(deltaX, deltaY)* 180 / Math.PI;
        
        this.speed = Math.sqrt((deltaX*deltaX) + (deltaY*deltaY));

        dispatchEvent(new MovementEvent(this, MovementEvent.POSITION_CHANGED));
    }
    
    /**
     * Stops and disposes of the movement.
     */
    public void stop(){
        dispatchEvent(new MovementEvent(this, MovementEvent.ENDED));
        dispose();
    }

    public long getDuration() {
        return System.currentTimeMillis() - startTime;
    }

    @Override
    public void dispose() {
        super.dispose();
        oldPosition = null;
        newPosition = null;
        startPosition = null;
    }
    
    

    public Point getStartPosition() {
        return startPosition;
    }

    public Point getOldPosition() {
        return oldPosition;
    }

    public Point getNewPosition() {
        return newPosition;
    }

    public int getDeltaX() {
        return deltaX;
    }

    public int getDeltaY() {
        return deltaY;
    }

    public double getVelocityX() {
        return velocityX;
    }

    public double getVelocityY() {
        return velocityY;
    }

    public double getSpeed() {
        return speed;
    }

    public double getAngle() {
        return angle;
    }

    @Override
    public String toString() {
        return "Movement{" + "startPosition=" + startPosition + ", oldPosition=" + oldPosition + ", newPosition=" + newPosition + ", deltaX=" + deltaX + ", deltaY=" + deltaY + ", velocityX=" + velocityX + ", velocityY=" + velocityY + ", speed=" + speed + ", angle=" + angle + '}';
    }
}
