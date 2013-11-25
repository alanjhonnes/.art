/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.algorist.art.util;

import com.algorist.art.model.Movement;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

/**
 * Utility class to randomly move a Movement object around the specified area.
 * @author user
 */
public class FluidMovement {

    protected Movement movement;
    protected Point point;
    protected double speed;
    protected double turnEase;
    protected double twitch;
    protected int maxX;
    protected int maxY;
    protected double D2R = Math.PI / 180;
    protected double R2D = 180 / Math.PI;
    protected Timer updateTimer;
    protected Timer goalTimer;
    protected ActionListener updateListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            updateMovement();
        }
    };
    protected ActionListener goalListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            updateGoal();
        }
    };

    public FluidMovement(Movement movement, Point point, double speed, double turnEase, double twitch, int interval, int maxX, int maxY) {
        this.movement = movement;
        this.point = point;
        this.speed = speed;
        this.turnEase = turnEase;
        this.twitch = twitch;
        this.maxX = maxX;
        this.maxY = maxY;

        goalTimer = new Timer(interval, goalListener);
        goalTimer.setRepeats(true);
        goalTimer.start();

        updateTimer = new Timer(16, updateListener);
        updateTimer.setRepeats(true);
        updateTimer.start();
    }

    protected void updateMovement() {
        Point pos = movement.getNewPosition();
        double angle = Math.atan2(point.y - pos.y, point.x - pos.x) * R2D;
        double deltaAngle = getDegreeDistance(movement.rotation, angle);

        movement.rotation += deltaAngle * turnEase + (Math.random() * twitch * 2) - twitch;
        int x = pos.x + (int) (Math.cos(movement.rotation * D2R) * speed);
        int y = pos.y + (int) (Math.sin(movement.rotation * D2R) * speed);

        movement.movePosition(new Point(x, y));
    }

    public double getDegreeDistance(double alpha, double beta) {
        double delta = D2R * (beta - alpha);
        return Math.atan2(Math.sin(delta), Math.cos(delta)) * R2D;
    }

    public void dispose() {
        goalTimer.stop();
        goalTimer.removeActionListener(goalListener);
        goalTimer = null;
        updateTimer.stop();
        updateTimer.removeActionListener(updateListener);
        updateTimer = null;
        movement = null;
        point = null;
    }

    public void updateGoal() {
        point.x = (int) (Math.random() * maxX);
        point.y = (int) (Math.random() * maxY);
    }
}
