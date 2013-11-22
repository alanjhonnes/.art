/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.algorist.art.view;

import com.algorist.art.controller.BrushPanelController;
import com.algorist.art.model.Art;
import com.algorist.art.model.brushes.presets.Preset;
import com.algorist.art.model.brushes.Brush;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.List;
import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import mvc.AbstractFrame;
import mvc.AbstractView;

/**
 *
 * @author alanjhonnes
 */
public class BrushPanelView extends AbstractView<JPanel> {

    private BrushPanelController controller;
    public Art artModel;
    public JLabel labelBrush;
    public JLabel labelPreset;
    public JComboBox<Brush> comboBrushes;
    public JComboBox<Preset> comboPresets;

    public BrushPanelView(AbstractFrame mainFrame, BrushPanelController controller, Art artModel) {
        super(mainFrame);
        this.artModel = artModel;
        this.controller = controller;
        setup();
    }

    @Override
    protected JPanel layout() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
        panel.setBorder(new EmptyBorder(5, 0, 5, 5));

        return panel;
    }

    private void repopulatePresets(List<Preset> presets) {
        comboPresets.setModel(new DefaultComboBoxModel<Preset>());
        for (Iterator<Preset> it = presets.iterator(); it.hasNext();) {
            Preset preset = it.next();
            comboPresets.addItem(preset);
        }
    }

    private void setup() {
        JPanel panel = getContentPane();
        comboBrushes = new JComboBox<>();
        comboBrushes.setMaximumSize(new Dimension(200, 20));

        List<Brush> brushes = controller.getBrushes();
        
        for (int i = 0; i < brushes.size(); i++) {
            Brush brush = brushes.get(i);
            comboBrushes.addItem(brush);
        }

        comboPresets = new JComboBox<>();
        comboPresets.setMaximumSize(new Dimension(200, 20));


        comboBrushes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                JComboBox<Brush> combo = (JComboBox<Brush>) ae.getSource();
                List<Preset> presets = combo.getItemAt(combo.getSelectedIndex()).getPresets();
                repopulatePresets(presets);
                controller.changeBrush(combo.getItemAt(combo.getSelectedIndex()));
            }
        });
        
        comboPresets.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                JComboBox<Preset> combo = (JComboBox<Preset>) ae.getSource();
                Preset preset = combo.getItemAt(combo.getSelectedIndex());
                controller.changePreset(preset);
            }
        });
        
        controller.changeBrush(comboBrushes.getItemAt(comboBrushes.getSelectedIndex()));

        repopulatePresets(comboBrushes.getItemAt(comboBrushes.getSelectedIndex()).getPresets());


        labelBrush = new JLabel("Pincel:");
        labelPreset = new JLabel("Preset:");

        labelBrush.setAlignmentX(Component.LEFT_ALIGNMENT);
        labelPreset.setAlignmentX(Component.LEFT_ALIGNMENT);
        comboBrushes.setAlignmentX(Component.LEFT_ALIGNMENT);
        comboPresets.setAlignmentX(Component.LEFT_ALIGNMENT);


        panel.add(labelBrush);
        panel.add(comboBrushes);
        panel.add(labelPreset);
        panel.add(comboPresets);

    }
}
