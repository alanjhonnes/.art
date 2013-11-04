/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.algorist.art.model.brushes;

import com.alanjhonnes.particles.SimpleParticle;
import com.algorist.art.model.Layer;
import com.algorist.art.model.Movement;
import com.algorist.art.model.brushes.parameters.Parameter;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.awt.image.Raster;
import java.awt.image.WritableRaster;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author alan.jbssa
 */
public class NeonParticles extends Brush {

    private double intensity;
    private int noise;
    private int spawn;
    private double damping;
    private int fuzz;
    private int exposure;
    private int initialXVelocity;
    private int initialYVelocity;
    private int maxAge;
    private float red;
    private float green;
    private float blue;
    private List<SimpleParticle> particles;
    private BufferedImage noiseCanvas;
    private WritableRaster noiseData, data, hdrdata;

    public NeonParticles() {
        super();
        intensity = 0.75;
        noise = 1;
        spawn = 10;
        maxAge = 70;
        exposure = 1;
        noise = 2;
        fuzz = 2;
        damping = 0.3;
        initialXVelocity = 15;
        initialYVelocity = 15;
        red = 1f;
        green = 0.1f;
        blue = 0.1f;
        particles = new ArrayList<>();
        name = "Neon Particles";
    }

    @Override
    public void initialize(Layer layer) {
        noiseCanvas = makeOctaveNoise(layer.getWidth(), layer.getHeight(), 8);
        noiseData = noiseCanvas.getRaster();
        //hdrdata = new WritableRaster();
    }

    @Override
    public void draw(Movement movement) {

        int w = layer.getWidth();
        int h = layer.getHeight();

        List<SimpleParticle> alive = new ArrayList<>(spawn);
        
        WritableRaster canvas = layer.getImage().getRaster();


        for (int i = 0; i < spawn; i++) {
            particles.add(new SimpleParticle(fuzzy(initialXVelocity), fuzzy(initialYVelocity), movement.getNewPosition().x, movement.getNewPosition().y));

            for (i = 0; i < particles.size(); i++) {
                SimpleParticle p = particles.get(i);
                int newVx = (int) (p.getVx() * damping + getNoise(p.getX(), p.getY(), 0) * 4 * noise + fuzzy(0.1) * fuzz);
                int newVY = (int) (p.getVy() * damping + getNoise(p.getX(), p.getY(), 0) * 4 * noise + fuzzy(0.1) * fuzz);
                p.setVx(newVx);
                p.setVy(newVY);
                p.setAge(p.getAge() + 1);

                for (int j = 0; j < 10; j++) {
                    p.setX((int) (p.getX() + p.getVx() * 0.1));
                    p.setY((int) (p.getY() + p.getVy() * 0.1));
                    if (p.getX() < 0 || p.getX() >= w || p.getY() < 0 || p.getY() >= h) {
                        continue;
                    }
                    float pixel[] = {red, green, blue};
                    canvas.setPixel(p.getX(), p.getY(), pixel);
                    

                }

                if (p.getAge() < maxAge) {
                    alive.add(p);
                }
            }

            
            

            particles = alive;
        }
    }

    @Override
    public void loadDefaultPresets() {
    }

    @Override
    public Map<String, Parameter> getParamTypes() {
        return null;
    }

    private int getNoise(int x, int y, int channel) {
        int pixel[] = noiseData.getPixel(x, y, new int[4]);
        return pixel[channel];
    }

    private int fuzzy(double range) {
        return (int) Math.round((Math.random() - 0.5) * range * 2);
    }

    private double tonemap(double n) {
        return (1 - Math.pow(2, -n * 0.005 * exposure)) * 255;
    }

    private BufferedImage makeOctaveNoise(int width, int height, int octaves) {
        BufferedImage canvas = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB_PRE);

        Graphics2D g = canvas.createGraphics();
        g.setColor(Color.black);
        g.fillRect(0, 0, width, height);



//        ctx.globalAlpha = 1 / octaves;
//        ctx.globalCompositeOperation = 'lighter';

    for (int i = 0; i < octaves; i++) {
            BufferedImage octave = makeNoise(width >> i, height >> i);
            //var octave = makeNoise(width, height);
            
            g.drawImage(octave, null, 0, 0);
        }

        return canvas;
    }

    private BufferedImage makeNoise(int width, int height) {

        BufferedImage canvas = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB_PRE);
        WritableRaster imgData = canvas.getRaster();

        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                double doubles[] = {Math.random(), Math.random(), Math.random(), 1f};
                imgData.setPixel(i, j, doubles);
            }
        }

        return canvas;
    }
}
