/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.algorist.art.model.brushes;

import com.alanjhonnes.graphics.noise.SimplexNoise;
import com.alanjhonnes.particles.SilkParticle;
import com.algorist.art.model.Movement;
import com.algorist.art.model.brushes.parameters.BooleanParameter;
import com.algorist.art.model.brushes.parameters.DoubleParameter;
import com.algorist.art.model.brushes.parameters.FloatParameter;
import com.algorist.art.model.brushes.parameters.IntParameter;
import com.algorist.art.model.brushes.parameters.Parameter;
import com.algorist.art.model.brushes.presets.Preset;
import com.algorist.art.model.brushes.presets.silkbrush.DefaultSilkBrushPreset;
import com.algorist.art.model.brushes.presets.silkbrush.HighSpreadSilkBrushPreset;
import com.algorist.art.model.brushes.presets.silkbrush.RandomColorSilkBrushPreset;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.RenderingHints;
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
    public int maxDist = 60;
    public float opacity = 0.3f;
    public double density = 1;
    public int spread = 90;
    public double bumpmapEffect = .4;
    public int scatter = 0;
    public int lifespan = 10;
    public double angleOffset = 0;
    public boolean fill = true;
    //shadow
    public int shadowMaxDist = 120;
    public float shadowOpacity = 0.075f;
    public double shadowDensity = 0.8;
    public int shadowSpread = 300;
    public int shadowScatter = 0;
    public int shadowLifespan = 4;
    public double shadowAngleOffset = 0;
    
    public float red = 1f;
    public float green = 1f;
    public float blue = 1f;
    
    public boolean useRandomColor = false;
    public boolean useShadows = false;
    public boolean fillShadows = true;
    public boolean useRandomAngleOffset = false;

    public SilkBrush() {
        this.name = "Silkbrush";
        particles = new ArrayList<>();
        shadowParticles = new ArrayList<>();
    }

    @Override
    public void initialize(int width, int height) {
        particles.clear();
        shadowParticles.clear();
        
    }

    @Override
    public void stopDrawing(Movement movement) {
        super.stopDrawing(movement); //To change body of generated methods, choose Tools | Templates.
        if(movements.isEmpty()){
            particles.clear();
            shadowParticles.clear();
        }
    }
    
    

    @Override
    protected void draw() {
        super.draw();
        //turn on anti-aliasing
        Graphics2D g = layer.getImage().createGraphics();
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        
        //render shadow particles
        for (int i = 0; i < shadowParticles.size(); i++) {
            SilkParticle particle = shadowParticles.get(i);
            particle.getDistances().clear();
            getDistances(particle, shadowParticles);
            drawLines(particle, shadowParticles, g);
            moveParticle(particle, shadowParticles);
            if (particle.age > shadowLifespan) {
                shadowParticles.remove(i);
            }
        }

        //render normal particles
        for (int i = 0; i < particles.size(); i++) {
            SilkParticle particle = particles.get(i);
            particle.getDistances().clear();
            getDistances(particle, particles);
            drawLines(particle, particles, g);
            moveParticle(particle, particles);
            if (particle.age > lifespan) {
                particles.remove(i);
            }
        }
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

            if (useShadows) {
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

        }

    }

    public void moveParticle(SilkParticle particle, List<SilkParticle> particles) {
        particle.px = particle.x;
        particle.py = particle.y;
        particle.x += Math.cos(particle.angle) * particle.speed;
        particle.y += Math.sin(particle.angle) * particle.speed;
        particle.age++;
        
        double noiseValue = SimplexNoise.noise(particle.x, particle.y);
        
        if(particles == this.particles){
            if(useRandomAngleOffset == false){
                particle.angle += angleOffset + bumpmapEffect * noiseValue; 
            }
            else {
                particle.angle += angleOffset * Math.random() - angleOffset / 2 + bumpmapEffect * noiseValue; 
            }
            
        }
        else {
            if(useRandomAngleOffset == false){
                particle.angle += shadowAngleOffset + bumpmapEffect * noiseValue; 
            }
            else {
                particle.angle += shadowAngleOffset * Math.random() - shadowAngleOffset / 2 + bumpmapEffect * noiseValue; 
            }
        }
    }

    public void getDistances(SilkParticle particle, List<SilkParticle> particles) {
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
        SilkParticle p = new SilkParticle(speed, speed, x, y);
        group.add(p);
        p.angle = angle;
        p.speed = speed;
        p.x = x;
        p.y = y;
        p.px = x;
        p.py = y;
        if (group == particles) {
            if (useRandomColor) {
                p.setColor(new Color((float) Math.random(), (float) Math.random(), (float) Math.random(), opacity));

            } else {
                p.setColor(new Color(red, green, blue, opacity));
            }
        } else {
            p.setColor(new Color(0, 0, 0, shadowOpacity));
        }

    }

    public void drawLines(SilkParticle particle, List<SilkParticle> particles, Graphics2D g) {
        int i = -1;
        int offsetX;
        int offsetY;
        int dist;
        int scatter;
        int spread;
        double dens;
        boolean fill;
        Polygon polygon = new Polygon();

        List<Integer> distances = particle.getDistances();
        
        //normal particles
        if(particles == this.particles){
            dist = maxDist;
            dens = density;
            scatter = this.scatter;
            spread = this.spread;
            fill = this.fill;
        }
        //shadow particles
        else {
            dist = shadowMaxDist;
            dens = shadowDensity;
            scatter = this.shadowScatter;
            spread = this.shadowSpread;
            fill = this.fillShadows;
        }
        
        while (++i < distances.size()) {
            SilkParticle p2 = particles.get(i);
            int distance = distances.get(i).intValue();
            if (distances.get(i) != null) {
                if (distance < dist && distance > 1 && Math.random() < dens) {
                    g.setColor(particle.getColor());

                    offsetX = (int) (scatter * Math.random() - scatter / 2);
                    offsetY = (int) (scatter * Math.random() - scatter / 2);

                    polygon.reset();

                    polygon.addPoint(particle.x + offsetX, particle.y + offsetY);
                    polygon.addPoint(p2.x + offsetX, p2.y + offsetY);
                    polygon.addPoint(p2.px + offsetX, p2.py + offsetY);
                    polygon.addPoint(particle.px + offsetX, particle.py + offsetY);

                    if(fill == true){
                        g.fillPolygon(polygon);
                    }
                    else {
                        g.drawPolygon(polygon);
                    }
                    
                }
            }
        }
    }

    @Override
    public void loadDefaultPresets() {
        presets.add(new DefaultSilkBrushPreset());
        presets.add(new RandomColorSilkBrushPreset());
        presets.add(new HighSpreadSilkBrushPreset());
    }

    @Override
    public void loadPreset(Preset preset) {
        if (preset.getBrushClass() == SilkBrush.class) {
            Map<String, Object> params = preset.getParams();
            this.maxDist = (int) params.get("maxDist");
            this.density = (double) params.get("density");
            this.lifespan = (int) params.get("lifespan");
            this.opacity = (float) params.get("opacity");
            this.scatter = (int) params.get("scatter");
            this.spread = (int) params.get("spread");
            this.shadowMaxDist = (int) params.get("shadowMaxDist");
            this.shadowDensity = (double) params.get("shadowDensity");
            this.shadowLifespan = (int) params.get("shadowLifespan");
            this.shadowOpacity = (float) params.get("shadowOpacity");
            this.shadowScatter = (int) params.get("shadowScatter");
            this.shadowSpread = (int) params.get("shadowSpread");
            
            this.bumpmapEffect = (double) params.get("bumpmapEffect");
            
            this.useShadows = (boolean) params.get("useShadows");
            
            
            if(params.get("useRandomColor") != null){
                this.useRandomColor = (boolean) params.get("useRandomColor");
            }
            
            if(params.get("red") != null){
                this.red = (float) params.get("red");
            }
            if(params.get("green") != null){
                this.green = (float) params.get("green");
            }
            if(params.get("blue") != null){
                this.blue = (float) params.get("blue");
            }
        }

    }

    @Override
    public List<Parameter> getParamTypes() {
        params.clear();
        
        params.add(new IntParameter("maxDist","Distâcia máxima",0, 500, maxDist));
        params.add(new IntParameter("shadowMaxDist", "Distancia (sombra)",0, 500, shadowMaxDist));
        params.add(new DoubleParameter("density", "% Densidade", 0, 1, density));
        params.add(new DoubleParameter("shadowDensity", "% Densidade (sombra)", 0, 1, shadowDensity));
        params.add(new IntParameter("lifespan", "Duração", 0, 50, lifespan));
        params.add(new IntParameter("shadowLifespan", "Duração (sombra)",0, 50, shadowLifespan));
        params.add(new IntParameter("scatter", "Dispersão",0, 400, scatter));
        params.add(new IntParameter("shadowScatter", "Dispersão (sombra)",0, 400, shadowScatter));
        params.add(new IntParameter("spread", "Propagação",0, 600, spread));
        params.add(new IntParameter("shadowSpread", "Propagação (sombra)",0, 600, shadowSpread));
        params.add(new DoubleParameter("angleOffset", "Distorção de ângulo", -1, 1, angleOffset));
        params.add(new DoubleParameter("shadowAngleOffset", "Distorção de ângulo (sombra)", -1, 1, shadowAngleOffset));
        params.add(new FloatParameter("opacity", "% Opacidade",0, 1, opacity));
        params.add(new FloatParameter("shadowOpacity", "% Opacidade (sombra)",0, 1, shadowOpacity));
        params.add(new FloatParameter("red", "% Vermelho", 0, 1, red));
        params.add(new FloatParameter("green", "% Verde",0, 1, green));
        params.add(new FloatParameter("blue", "% Azul",0, 1, blue));
        
        params.add(new DoubleParameter("bumpmapEffect", "% Distorção por bumpmap", 0, 1, bumpmapEffect));
        
        params.add(new BooleanParameter("useShadows", "Usar sombras", useShadows));
        params.add(new BooleanParameter("useRandomColor", "Cores aleatórias", useRandomColor));
        params.add(new BooleanParameter("fill", "Preencher", fill));
        params.add(new BooleanParameter("fillShadows", "Preencher sombras", fillShadows));
        params.add(new BooleanParameter("useRandomAngleOffset", "Distorcer ângulo", useRandomAngleOffset));
        return params;
    }
    
    
}
