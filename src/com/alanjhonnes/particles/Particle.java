/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alanjhonnes.particles;

/**
 * Base particle class containing just the position of the particle.
 * @author alan.jbssa
 */
public abstract class Particle {
    
    public int x;
    public int y;

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
    
}
