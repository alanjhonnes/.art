/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.algorist.art.view;

import com.alanjhonnes.event.CallbackFunction;
import com.alanjhonnes.event.Event;
import com.algorist.art.controller.DrawingAreaController;
import com.algorist.art.event.DocumentEvent;
import com.algorist.art.model.Document;
import com.algorist.art.model.Layer;
import com.algorist.art.view.display.LayerPanel;
import java.awt.Dimension;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JLayeredPane;
import mvc.AbstractFrame;
import mvc.AbstractView;

/**
 *
 * @author alanjhonnes
 */
public class DrawingAreaView extends AbstractView<JLayeredPane> implements ComponentListener {

    private DrawingAreaController controller;
    private MouseListener mouseListener;
    private MouseMotionListener mouseMotionListener;
    private Document documentModel;
    private List<LayerPanel> layerPanels;

    public DrawingAreaView(AbstractFrame mainFrame, DrawingAreaController controller, final Document documentModel) {
        super(mainFrame);
        this.controller = controller;
        controller.setView(this);
        this.documentModel = documentModel;
        layerPanels = new ArrayList<>();
        setupLayers();
        this.documentModel.addEventListener(DocumentEvent.LAYER_ADDED, new CallbackFunction() {
            @Override
            public void execute(Event e) {
            }
        });

        this.documentModel.addEventListener(DocumentEvent.LAYER_REMOVED, new CallbackFunction() {
            @Override
            public void execute(Event e) {
            }
        });

        this.documentModel.addEventListener(DocumentEvent.LAYERS_ORDER_CHANGED, new CallbackFunction() {
            @Override
            public void execute(Event e) {
            }
        });
        
        this.documentModel.addEventListener(DocumentEvent.SIZE_CHANGED, new CallbackFunction() {

            @Override
            public void execute(Event e) {
                contentPane.setPreferredSize(new Dimension(documentModel.getWidth(), documentModel.getHeight()));
            }
        });
    }

    @Override
    protected JLayeredPane layout() {
        JLayeredPane panel = new JLayeredPane();
        //panel.setPreferredSize(new Dimension(600, 500));
        

        mouseListener = new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if (e.getButton() == MouseEvent.BUTTON1) {
                    controller.movementStarted(e.getPoint());
                }
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                if (e.getButton() == MouseEvent.BUTTON1) {
                    controller.movementEnded();
                }
            }
        };

        mouseMotionListener = new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent e) {
                controller.movementUpdated(e.getPoint());
            }

            @Override
            public void mouseMoved(MouseEvent e) {
            }
        };

        panel.addMouseListener(mouseListener);
        panel.addMouseMotionListener(mouseMotionListener);
        panel.addComponentListener(this);
        return panel;
    }

    private void setupLayers() {
        List<Layer> layers = documentModel.getLayers();
        for (int i = 0; i < layers.size(); i++) {
            Layer layer = layers.get(i);
            LayerPanel layerPanel = new LayerPanel(layer);
            layerPanel.setBounds(0, 0, layer.getWidth(), layer.getHeight());
            getContentPane().add(layerPanel, new Integer(i));
            layerPanels.add(layerPanel);
        }
    }

    public List<LayerPanel> getLayerPanels() {
        return layerPanels;
    }

    public Document getDocumentModel() {
        return documentModel;
    }

    public void updateLayer(Layer selectedLayer) {
        for (int i = 0; i < layerPanels.size(); i++) {
            LayerPanel layerPanel = layerPanels.get(i);
            if(layerPanel.getLayer() == selectedLayer){
                layerPanel.repaint();
                break;
            }
        }
    }
    
    
    
    
     public void componentHidden(ComponentEvent e) {
        System.out.println(e.getComponent().getClass().getName() + " --- Hidden");
    }

    public void componentMoved(ComponentEvent e) {
        System.out.println(e.getComponent().getClass().getName() + " --- Moved");
    }

    public void componentResized(ComponentEvent e) {
        documentModel.setSize(contentPane.getWidth(), contentPane.getHeight());    
    }

    public void componentShown(ComponentEvent e) {
        System.out.println(e.getComponent().getClass().getName() + " --- Shown");

    }
}
