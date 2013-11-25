/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alanjhonnes.particles;

/**
 * Simple particle implementing age and velocity.
 * @author alan.jbssa
 */
public class SimpleParticle extends Particle {
    
    public double vx;
    public double vy;
    public int age;

    public SimpleParticle(double vx, double vy, int x, int y) {
        this.vx = vx;
        this.vy = vy;
        this.x = x;
        this.y = y;
        this.age = 0;
    }

    public double getVx() {
        return vx;
    }

    public void setVx(double vx) {
        this.vx = vx;
    }

    public double getVy() {
        return vy;
    }

    public void setVy(double vy) {
        this.vy = vy;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    
}
