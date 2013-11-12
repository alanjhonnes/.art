/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.algorist.art.model.brushes;

import com.alanjhonnes.particles.Particle;
import com.alanjhonnes.particles.SimpleParticle;
import com.algorist.art.model.Layer;
import com.algorist.art.model.Movement;
import com.algorist.art.model.brushes.parameters.Parameter;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author alan.jbssa
 */
public class SilkBrush extends Brush {

    private List<SimpleParticle> particles;
    private List<SimpleParticle> shadowParticles;
    private BufferedImage bumpmap;
    private int maxDist = 100;
    private double opacity = 0.3;
    private double density = 1;
    private int spread = 90;
    private int bumpmapScale = 100;
    private double bumpmapEffect = .4;
    private int scatter = 0;
    private int lifespan = 10;
    //shadow
    private int shadowMaxDist = 120;
    private double shadowOpacity = 0.075;
    private double shadowDensity = 0.8;
    private int shadowSpread = 433;
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
    public void draw(Movement movement) {
        
        
        
        
    }
    
    private void makeParticle(int f_x, int f_y, double f_angle, double f_speed, List<Particle> group){
		var p = {};
		group.push(p);
		p.angle = f_angle
		p.speed = f_speed
		p.ox = mouseData.px1;
		p.oy = mouseData.py1;
		p.x = f_x;
		p.y = f_y;
		p.px = p.x;
		p.py = p.y;
		p.age = 0;
		p.distances = new Array();
		p.color = 0xffffff;//colormap.bitmapData.getPixel(propX * colormap.width, propY * colormap.height);
		if (cmapCtx){
			propX = p.x / $("#drawer").width();
			propY = p.y / $("#drawer").height();
			data = cmapData.data//.getImageData(propX * cmapCtx.width, propY * cmapCtx.height,1, 1)
			col = (propX * cmapData.width) << 2;
			row = (propY * cmapData.height) >> 0;
			rowWidth = cmapData.width << 2
			p.color = (data[col + (row * rowWidth) + 0] << 16) | (data[col + (row * rowWidth) + 1] << 8) | data[col + (row * rowWidth) + 2];
			
		}
	}

	function setInitialPosition(f_obj, f_method){
		if (!f_method){
			f_method = 0;
		}

		switch (f_method){
			// circle
			case 0:
				ringAngle = getRandomFromRange(0, Math.PI * 2)
				f_obj.x = Math.cos(ringAngle) * ringRadius + centerX;
				f_obj.y = Math.sin(ringAngle) * ringRadius + centerY;
				break;

			//Horizontal Line
			case 1:
				f_obj.x = Math.random() * $("#drawer").width();
				f_obj.y = $("#drawer").height() >> 1;
				break;

			//Random
			case 2:
				f_obj.x = Math.random() * $("#drawer").width();
				f_obj.y = Math.random() * $("#drawer").height();
				break;
		}
	}
    
    
    
    

    @Override
    public void loadDefaultPresets() {
    }

    @Override
    public Map<String, Parameter> getParamTypes() {
        return null;
    }
}
