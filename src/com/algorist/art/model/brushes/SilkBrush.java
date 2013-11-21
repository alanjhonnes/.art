/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.algorist.art.model.brushes;

import com.alanjhonnes.particles.SilkParticle;
import com.algorist.art.model.Layer;
import com.algorist.art.model.Movement;
import com.algorist.art.model.brushes.parameters.Parameter;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author alan.jbssa
 */
public class SilkBrush extends Brush {

    private List<SilkParticle> particles;
    private List<SilkParticle> shadowParticles;
    private BufferedImage bumpmap;
    private int maxDist = 60;
    private float opacity = 0.3f;
    private double density = 1;
    private int spread = 90;
    private int bumpmapScale = 100;
    private double bumpmapEffect = .4;
    private int scatter = 0;
    private int lifespan = 10;
    //shadow
    private int shadowMaxDist = 120;
    private float shadowOpacity = 0.075f;
    private double shadowDensity = 0.8;
    private int shadowSpread = 300;
    private int shadowScatter = 0;
    private int shadowLifespan = 4;
    private boolean useShadows = false;
    private float red = 1f;
    private float green = 1f;
    private float blue = 1f;

    public SilkBrush() {
        this.name = "Silkbrush";
    }

    @Override
    public void initialize(Layer layer) {
        particles = new ArrayList<>();
        shadowParticles = new ArrayList<>();
    }

    @Override
    public void startDrawing(Movement movement, Layer layer) {
        super.startDrawing(movement, layer); //To change body of generated methods, choose Tools | Templates.
        
    }
    
    

    @Override
    public void draw(Movement movement) {

        if (movement.getSpeed() > 0) {
            //2 normal particles
            makeParticle(
                    (int) movement.getNewPosition().getX(),
                    (int) movement.getNewPosition().getY(),
                    movement.getAngle() + (Math.PI * 0.5), 1 / movement.getSpeed() * spread,
                    particles);
            makeParticle(
                    (int) movement.getNewPosition().getX(), 
                    (int) movement.getNewPosition().getY(), 
                    movement.getAngle() - (Math.PI * 0.5), 1 / movement.getSpeed() * spread, 
                    particles);
            //2 shadow particles
            makeParticle(
                    (int) movement.getNewPosition().getX(),
                    (int) movement.getNewPosition().getY(),
                    movement.getAngle() + (Math.PI * 0.5), 1 / movement.getSpeed() * shadowSpread,
                    shadowParticles);
            makeParticle(
                    (int) movement.getNewPosition().getX(), 
                    (int) movement.getNewPosition().getY(), 
                    movement.getAngle() - (Math.PI * 0.5), 1 / movement.getSpeed() * shadowSpread, 
                    shadowParticles);
        }
        
        Graphics2D g = layer.getImage().createGraphics();
        
        for (int i = 0; i < particles.size(); i++) {
            SilkParticle particle = particles.get(i);
            particle.getDistances().clear();
            getDistances(particle, i, particles);
            drawLines(particle, i, particles, g);
            moveParticle(particle, i, particles);
            if(particle.age > lifespan){
                particles.remove(i);
            }
        }
        
        for (int i = 0; i < shadowParticles.size(); i++) {
            SilkParticle particle = shadowParticles.get(i);
            particle.getDistances().clear();
            getDistances(particle, i, shadowParticles);
            drawLines(particle, i, shadowParticles, g);
            moveParticle(particle, i, shadowParticles);
            if(particle.age > shadowLifespan){
                shadowParticles.remove(i);
            }
        }

    }

    public void moveParticle(SilkParticle particle, int id, List<SilkParticle> particles) {
        particle.px = particle.x;
        particle.py = particle.y;
        if (particle.x < 0 || particle.x > layer.getWidth() || particle.y < 0 || particle.y > layer.getHeight()) {
        } else {
            int propX = particle.x / layer.getWidth();
            int propY = particle.y / layer.getHeight();
            //var colorVal = 0x80; //bumpmap.bitmapData.getPixel(propX * 100, propY * 100);
            //colorVal = (colorVal & 0xff) - 0x80;
            //var angleOffset = bumpmapEffect * (colorVal / 0x80);
            
            
            
            
//            colorVal = bumpmap.noise((bumpmap.offsetX + particle.x) / bumpmap.scale, (bumpmap.offsetY + particle.y) / bumpmap.scale);
//            var angleOffset = bumpmapEffect * colorVal;
//            particle.angle += angleOffset;


//            if (particles == this.particles) {
//                
//                
//            } else if (particles == shadowParticles) {
//                particle.setColor(new Color(0f, 0f, 0f, (float) shadowOpacity));
//            }

//            particle.angle += 0.15;
        }
        particle.x += Math.cos(particle.angle) * particle.speed;
        particle.y += Math.sin(particle.angle) * particle.speed;
        particle.age++;
        
//        if(particles == this.particles){
//            Color c = particle.getColor();
//        float lifeRatio = particle.age / lifespan;
////        int red = (int) (c.getRed()* lifeRatio);
////        int green = (int) (c.getGreen() * lifeRatio);
////        int blue = (int) (c.getBlue() * lifeRatio);
//        
////        float red = (float) (c.getRed() / 256);
////        float green = (float) (c.getGreen() / 256);
////        float blue =  (float) (c.getBlue() / 256);
//        particle.setColor(new Color(red, green, blue, opacity));
//        }
        
        

    }

    public void resetDistances(SilkParticle particle, int id) {
        particle.getDistances().clear();
    }

    public void getDistances(SilkParticle particle, int id, List<SilkParticle> particles) {
        List<Integer> distances = particle.getDistances();
        int dx;
        int dy;
        for (int i = 0; i < particles.size(); i++) {
            SilkParticle p = particles.get(i);
            dx = p.x - particle.x;
                dy = p.y - particle.y;
                distances.add(new Integer((int) (Math.sqrt((dx * dx) + (dy * dy)))));
        }
    }

    private void makeParticle(int x, int y, double angle, double speed, List<SilkParticle> group) {
        SilkParticle p = new SilkParticle(speed, opacity, x, y);
        group.add(p);
        p.angle = angle;
        p.speed = speed;
        p.x = x;
        p.y = y;
        p.px = x;
        p.py = y;
        if(group == particles){
            p.setColor(new Color(1,1,1, opacity));
        }
        else {
            p.setColor(new Color(0,0,0, shadowOpacity));
        }
        
    }



    public void drawLines(SilkParticle particle, int id, List<SilkParticle> particles, Graphics2D g) {
        int i = -1;
        int offsetX;
        int offsetY;
        Polygon polygon = new Polygon();

        List<Integer> distances = particle.getDistances();
        while (++i < distances.size()) {
            SilkParticle p2 = particles.get(i);
            int distance = distances.get(i).intValue();
            if (distances.get(i) != null) {
                if (distance < maxDist && distance > 1 && Math.random() < density) {
                    g.setColor(particle.getColor());

                    offsetX = (int) (scatter * Math.random() - scatter / 2);
                    offsetY = (int) (scatter * Math.random() - scatter / 2);

                    polygon.reset();

                    polygon.addPoint(particle.x + offsetX, particle.y + offsetY);
                    polygon.addPoint(p2.x + offsetX, p2.y + offsetY);
                    polygon.addPoint(p2.px + offsetX, p2.py + offsetY);
                    polygon.addPoint(particle.px + offsetX, particle.py + offsetY);

                    g.fillPolygon(polygon);
                }
            }
        }
    }

    public void drawShadows(SilkParticle particle, int id, List<SilkParticle> particles, Graphics2D g) {
        int i = -1;

        int offsetX;
        int offsetY;

        Polygon polygon = new Polygon();

        List<Integer> distances = particle.getDistances();

        while (++i < distances.size()) {
            SilkParticle p2 = particles.get(i);
            int distance = distances.get(i).intValue();
            if (distances.get(i) != null) {
                if (distance < shadowMaxDist && distance > 1 && Math.random() < shadowDensity) {
                    g.setColor(particle.getColor());

                    offsetX = (int) (scatter * Math.random() - scatter / 2);
                    offsetY = (int) (scatter * Math.random() - scatter / 2);

                    polygon.reset();

                    polygon.addPoint(particle.x + offsetX, particle.y + offsetY);
                    polygon.addPoint(p2.x + offsetX, p2.y + offsetY);
                    polygon.addPoint(p2.px + offsetX, p2.py + offsetY);
                    polygon.addPoint(particle.px + offsetX, particle.py + offsetY);

                    g.fillPolygon(polygon);
                }
            }
        }
    }

    public double getRandomFromRange(double f_min, double f_max) {
        return (Math.random() * (f_max - f_min)) + f_min;
    }

    @Override
    public void loadDefaultPresets() {
    }

    @Override
    public Map<String, Parameter> getParamTypes() {
        return null;
    }
}
