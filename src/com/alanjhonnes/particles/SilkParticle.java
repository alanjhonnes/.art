/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alanjhonnes.particles;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * Particle used by the SilkBrush class.
 * @author user
 */
public class SilkParticle extends SimpleParticle {
    
    public double angle;
    protected List<Integer> distances;
    
    protected Color color; 
    
    public int px;
    public int py;
    public double speed;

    public SilkParticle(double vx, double vy, int x, int y) {
        super(vx, vy, x, y);
        distances = new ArrayList<>();
    }

    public double getAngle() {
        return angle;
    }

    public void setAngle(double angle) {
        this.angle = angle;
    }

    public List<Integer> getDistances() {
        return distances;
    }

    public void setDistances(List<Integer> distances) {
        this.distances = distances;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
    
    
    
}
