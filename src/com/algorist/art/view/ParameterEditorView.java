/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.algorist.art.view;

import com.algorist.art.controller.ParameterEditorController;
import com.algorist.art.model.brushes.parameters.BooleanParameter;
import com.algorist.art.model.brushes.parameters.ColorParameter;
import com.algorist.art.model.brushes.parameters.DoubleParameter;
import com.algorist.art.model.brushes.parameters.FloatParameter;
import com.algorist.art.model.brushes.parameters.IntParameter;
import com.algorist.art.model.brushes.parameters.Parameter;
import com.algorist.art.view.display.BooleanCheckbox;
import com.algorist.art.view.display.ColorPicker;
import com.algorist.art.view.display.DoubleSlider;
import com.algorist.art.view.display.FloatSlider;
import com.algorist.art.view.display.IntSlider;
import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;
import javax.swing.BoxLayout;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.colorchooser.ColorSelectionModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import mvc.AbstractFrame;
import mvc.AbstractView;

/**
 *
 * @author alan.jbssa
 */
public class ParameterEditorView extends AbstractView<JScrollPane> {
    
    private List<JComponent> components;
    private final ParameterEditorController controller; 
    private JPanel panel;

    public ParameterEditorView(AbstractFrame mainFrame, ParameterEditorController controller) {
        super(mainFrame);
        this.controller = controller;
        controller.setView(this);
        components = new ArrayList<>();
    }

    @Override
    protected JScrollPane layout() {
        panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        JScrollPane container = new JScrollPane(panel);
        //panel.setPreferredSize(new Dimension(180, 100));
        //container.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        return container;
    }

    public void setupParams(List<Parameter> params) {
        for (int i = 0; i < components.size(); i++) {
            JComponent component = components.get(i);
            panel.remove(component);
        }
        
        for (int i = 0; i < params.size(); i++) {
            Parameter parameter = params.get(i);
            if(parameter.getType() == int.class){
                IntParameter intParameter = (IntParameter) parameter;
                IntSlider intSlider = new IntSlider(intParameter.getKey(), intParameter.getMin(), intParameter.getMax(), intParameter.getValue());
                JLabel label = new JLabel(parameter.getKey());
                components.add(label);
                panel.add(label);
                components.add(intSlider);
                panel.add(intSlider);
                intSlider.addChangeListener(intChangeListener);
            }
            
            else if(parameter.getType() == float.class){
                FloatParameter floatParameter = (FloatParameter) parameter;
                FloatSlider floatSlider = new FloatSlider(floatParameter.getKey(), (int) (floatParameter.getMin() * 100), (int) (floatParameter.getMax() * 100), (int) (floatParameter.getValue()* 100), 100);
                JLabel label = new JLabel(parameter.getKey());
                components.add(label);
                panel.add(label);
                components.add(floatSlider);
                panel.add(floatSlider);
                floatSlider.addChangeListener(floatChangeListener);
            }
            
            else if(parameter.getType() == double.class){
                DoubleParameter doubleParameter = (DoubleParameter) parameter;
                DoubleSlider doubleSlider = new DoubleSlider(doubleParameter.getKey(), (int) (doubleParameter.getMin() * 100), (int) (doubleParameter.getMax() * 100), (int) (doubleParameter.getValue() * 100), 100 );
                JLabel label = new JLabel(parameter.getKey());
                components.add(label);
                panel.add(label);
                components.add(doubleSlider);
                panel.add(doubleSlider);
                doubleSlider.addChangeListener(doubleChangeListener);
            }
            else if(parameter.getType() == boolean.class){
                BooleanParameter booleanParameter = (BooleanParameter) parameter;
                BooleanCheckbox booleanCheckbox = new BooleanCheckbox(booleanParameter.getKey(), booleanParameter.getValue(), booleanParameter.getKey());
                components.add(booleanCheckbox);
                panel.add(booleanCheckbox);
                booleanCheckbox.addChangeListener(booleanChangeListener);
            }
            else if(parameter.getType() == Color.class){
                ColorParameter colorParameter = (ColorParameter) parameter;
                ColorPicker colorPicker = new ColorPicker(colorParameter.getKey(), colorParameter.getValue());
                components.add(colorPicker);
                panel.add(colorPicker);
                colorPicker.getSelectionModel().addChangeListener(colorChangeListener);
            }
        }
        
        panel.revalidate();
    }
    
    private ChangeListener intChangeListener = new ChangeListener() {

        @Override
        public void stateChanged(ChangeEvent e) {
            IntSlider intSlider = (IntSlider) e.getSource();
            controller.intChanged(intSlider.getKey(), intSlider.getValue());
        }
    };
    
    private ChangeListener floatChangeListener = new ChangeListener() {

        @Override
        public void stateChanged(ChangeEvent e) {
            FloatSlider floatSlider = (FloatSlider) e.getSource();
            controller.floatChanged(floatSlider.getKey(), floatSlider.getScaledValue());
        }
    };
    
    private ChangeListener doubleChangeListener = new ChangeListener() {

        @Override
        public void stateChanged(ChangeEvent e) {
            DoubleSlider doubleSlider = (DoubleSlider) e.getSource();
            controller.doubleChanged(doubleSlider.getKey(), doubleSlider.getScaledValue());
        }
    };
    
    private ChangeListener booleanChangeListener = new ChangeListener() {

        @Override
        public void stateChanged(ChangeEvent e) {
            BooleanCheckbox checkbox = (BooleanCheckbox) e.getSource();
            controller.booleanChanged(checkbox.getKey(), checkbox.isSelected());
        }
    };
    
    private ChangeListener colorChangeListener = new ChangeListener() {

        @Override
        public void stateChanged(ChangeEvent e) {
            ColorSelectionModel colorSelectionModel = (ColorSelectionModel) e.getSource();
            String key = null;
            for (int i = 0; i < components.size(); i++) {
                JComponent jComponent = components.get(i);
                if(jComponent.getClass() == ColorPicker.class){
                    ColorPicker cp = (ColorPicker) jComponent;
                    if(cp.getSelectionModel() == colorSelectionModel){
                        key = cp.getKey();
                        break;
                    }
                }
            }
            controller.colorChanged(key, colorSelectionModel.getSelectedColor());
        }
    };
    
}
