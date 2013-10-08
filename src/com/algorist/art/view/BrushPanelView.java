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
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import mvc.AbstractFrame;
import mvc.AbstractView;

/**
 *
 * @author senac2012
 */
public class BrushPanelView extends AbstractView<JPanel> implements Observer {

    public JComboBox<Brush> comboBrushes;
    public JComboBox<Preset> comboPresets;

    public BrushPanelView(AbstractFrame mainFrame) {
        super(mainFrame);
    }

    @Override
    protected JPanel layout() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        comboBrushes = new JComboBox<>();
        comboBrushes.setMaximumSize(new Dimension(200, 20));


        CirclesBrush circlesBrush = new CirclesBrush();

        comboBrushes.addItem(circlesBrush);
        comboBrushes.addItem(new LinesBrush());

        comboPresets = new JComboBox<>();
        comboPresets.setMaximumSize(new Dimension(200, 20));


        comboBrushes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                JComboBox<Brush> combo = (JComboBox<Brush>) ae.getSource();
                List<Preset> presets = combo.getItemAt(combo.getSelectedIndex()).getPresets();
                repopulatePresets(presets);
            }
        });

        repopulatePresets(circlesBrush.getPresets());


        panel.add(new JLabel("Pincel:"));
        panel.add(comboBrushes);
        panel.add(new JLabel("Preset:"));
        panel.add(comboPresets);

        return panel;
    }

    private void repopulatePresets(List<Preset> presets) {
        comboPresets.setModel(new DefaultComboBoxModel<Preset>());
        for (Iterator<Preset> it = presets.iterator(); it.hasNext();) {
            Preset preset = it.next();
            comboPresets.addItem(preset);
        }
    }

    @Override
    public void update(Observable o, Object o1) {
    }
}
