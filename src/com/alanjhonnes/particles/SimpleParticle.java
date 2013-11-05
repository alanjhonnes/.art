/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alanjhonnes.particles;

/**
 *
 * @author alan.jbssa
 */
public class SimpleParticle extends Particle {
    
    private int vx;
    private int vy;
    private int age;

    public SimpleParticle(int vx, int vy, int x, int y) {
        this.vx = vx;
        this.vy = vy;
        this.x = x;
        this.y = y;
        this.age = 0;
    }

    public int getVx() {
        return vx;
    }

    public void setVx(int vx) {
        this.vx = vx;
    }

    public int getVy() {
        return vy;
    }

    public void setVy(int vy) {
        this.vy = vy;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    
}
