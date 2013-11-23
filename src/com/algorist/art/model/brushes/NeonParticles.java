/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.algorist.art.model.brushes;

import com.alanjhonnes.particles.SimpleParticle;
import com.algorist.art.model.Layer;
import com.algorist.art.model.Movement;
import com.algorist.art.model.brushes.parameters.DoubleParameter;
import com.algorist.art.model.brushes.parameters.FloatParameter;
import com.algorist.art.model.brushes.parameters.IntParameter;
import com.algorist.art.model.brushes.parameters.Parameter;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author alan.jbssa
 */
public class NeonParticles extends Brush {

    public double intensity;
    public int noise;
    public int spawn;
    public double damping;
    public int fuzz;
    public int exposure;
    public int initialXVelocity;
    public int initialYVelocity;
    public int maxAge;
    public float red;
    public float green;
    public float blue;
    public float opacity;
    private List<SimpleParticle> particles;
    private BufferedImage noiseCanvas;
    private WritableRaster noiseData, data, hdrdata;
    

    public NeonParticles() {
        super();
        intensity = 1;
        spawn = 10;
        maxAge = 70;
        exposure = 1;
        noise = 1;
        fuzz = 1;
        damping = 0.8;
        initialXVelocity = 10;
        initialYVelocity = 10;
        red = 1f;
        green = 0.1f;
        blue = 0.1f;
        opacity = 0.2f;
        name = "Neon Particles";
    }

    @Override
    public void initialize(Layer layer) {
        noiseCanvas = makeOctaveNoise(layer.getWidth(), layer.getHeight(), 8);
        noiseData = noiseCanvas.getRaster();
        System.out.println(noiseData);
        particles = new ArrayList<>();
        //hdrdata = new WritableRaster();
    }

    @Override
    public void startDrawing(Movement movement, Layer layer) {
        super.startDrawing(movement, layer); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void draw(Movement movement) {

        int w = layer.getWidth();
        int h = layer.getHeight();

        List<SimpleParticle> alive = new ArrayList<>();

        WritableRaster canvas = layer.getImage().getRaster();

        Graphics2D g = layer.getImage().createGraphics();
        g.setRenderingHint(
                RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        //g.setComposite(new BlendComposite());

        for (int i = 0; i < spawn; i++) {
            particles.add(new SimpleParticle(fuzzy(initialXVelocity), fuzzy(initialYVelocity), movement.getNewPosition().x, movement.getNewPosition().y));
        }

        for (int i = 0; i < particles.size(); i++) {
            SimpleParticle p = particles.get(i);

            //g.setColor(new Color(tonemap(red), tonemap(green), tonemap(blue), 1f));
            
            //System.out.println(getNoise(p.getX(), p.getY(), 0));
            //int newVx = (int) (p.getVx() * damping + getNoise(p.getX(), p.getY(), 0) * 4 * noise + fuzzy(0.1) * fuzz);
            //int newVy = (int) (p.getVy() * damping + getNoise(p.getX(), p.getY(), 0) * 4 * noise + fuzzy(0.1) * fuzz);
            //int newVx = (int) (p.getVx() * damping * 4 * noise + fuzzy(0.1) * fuzz);
            //int newVy = (int) (p.getVy() * damping * 4 * noise + fuzzy(0.1) * fuzz);
//            double newVx = p.getVx() * damping + getNoise(p.getX(), p.getY(), 0) * 4 * noise + fuzzy(0.1) * fuzz;
//            double newVy = p.getVy() * damping + getNoise(p.getX(), p.getY(), 0) * 4 * noise + fuzzy(0.1) * fuzz;
//            double newVx = p.getVx() * damping;
//            double newVy = p.getVy() * damping;

            double newVx = p.getVx() * damping + fuzzy(1) * 4 * noise + fuzzy(0.1) * fuzz;
            double newVy = p.getVy() * damping + fuzzy(1) * 4 * noise + fuzzy(0.1) * fuzz;

            p.setVx(newVx);
            p.setVy(newVy);
            p.setAge(p.getAge() + 1);

            p.setX((int) (p.getX() + p.getVx()));
            p.setY((int) (p.getY() + p.getVy()));

            if (p.getAge() < maxAge) {
                alive.add(p);
            }

            if (p.getX() < 0 || p.getX() >= w || p.getY() < 0 || p.getY() >= h) {
                continue;
            }
            
            g.setColor(new Color(red, green, blue, opacity));
            g.drawOval(p.getX(), p.getY(), 8, 8);
        }
        particles = alive;
    }

    @Override
    public void loadDefaultPresets() {
    }

    private int getNoise(int x, int y, int channel) {
        System.out.println("x: " + x + " y: " + y);
        if (x >= 0 && x <= noiseData.getWidth() && y >= 0 && y <= noiseData.getHeight()) {
            int pixel[] = noiseData.getPixel(x, y, new int[4]);
            return pixel[channel];
        }
        return 0;

    }

    private double fuzzy(double range) {
        return (Math.random() - 0.5) * range;
    }

    private float tonemap(float n) {
        return (float) ((1 - Math.pow(2, -n * 0.005 * exposure)) * 255);
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

    @Override
    public void defineParameters() {
        
    }

    @Override
    public List<Parameter> getParamTypes() {
        params.clear();
//        public double intensity;
//    public int noise;
//    public int spawn;
//    public double damping;
//    public int fuzz;
//    public int exposure;
//    public int initialXVelocity;
//    public int initialYVelocity;
//    public int maxAge;
//    public float red;
//    public float green;
//    public float blue;
//    public float opacity;
        params.add(new DoubleParameter("intensity", 0, 1, intensity));
        params.add(new IntParameter("noise", 0, 10, noise));
        params.add(new IntParameter("spawn", 0, 200, spawn));
        params.add(new DoubleParameter("damping", 0, 1, damping));
        params.add(new IntParameter("fuzz", 0, 10, fuzz));
        params.add(new IntParameter("exposure", 0, 10, exposure));
        params.add(new IntParameter("initialXVelocity", 0, 100, initialXVelocity));
        params.add(new IntParameter("initialYVelocity", 0, 100, initialYVelocity));
        params.add(new IntParameter("maxAge", 0, 150, maxAge));
        params.add(new FloatParameter("red", 0, 1, red));
        params.add(new FloatParameter("green", 0, 1, green));
        params.add(new FloatParameter("blue", 0, 1, blue));
        params.add(new FloatParameter("opacity", 0, 1, opacity));
        return params;
    }
    
    
    
    
}
