/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.algorist.art.view;

import com.algorist.art.model.brushes.presets.Preset;
import com.algorist.art.model.brushes.Brush;
import com.algorist.art.model.brushes.CirclesBrush;
import com.algorist.art.model.brushes.LinesBrush;
import java.awt.Dimension;
import java.util.Observable;
import java.util.Observer;
import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import mvc.AbstractFrame;
import mvc.AbstractView;

/**
 *
 * @author senac2012
 */
public class BrushPanelView extends AbstractView<JPanel> implements Observer {

    public BrushPanelView(AbstractFrame mainFrame) {
        super(mainFrame);
    }

    @Override
    protected JPanel layout() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        JComboBox<Brush> comboBrushes = new JComboBox<>();
        comboBrushes.setMaximumSize(new Dimension(200, 20));
        
        
        CirclesBrush circlesBrush = new CirclesBrush();
        
        comboBrushes.addItem(circlesBrush);
        comboBrushes.addItem(new LinesBrush());
        
        JComboBox<Preset> comboPresets = new JComboBox<>();
        comboPresets.setMaximumSize(new Dimension(200, 20));
        
        
        
        panel.add(comboBrushes);
        panel.add(comboPresets);
        return panel;
    }

    @Override
    public void update(Observable o, Object o1) {
        
    }
    
    
    
    
    
}
