package com.algorist.art.view;


import com.algorist.art.ModelAcessor;
import com.algorist.art.controller.BrushPanelController;
import com.algorist.art.controller.DrawingAreaController;
import com.algorist.art.controller.LayerPanelController;
import com.algorist.art.model.Document;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;
import mvc.AbstractFrame;

public class MainFrame extends AbstractFrame {
    
    public JMenuBar menu;
    
    public JScrollPane drawingContainer;
    public JPanel drawingArea;
    
    public JScrollPane panelScroller;
    public JScrollPane brushScroller;
    public JScrollPane layerScroller;
    
    public JPanel panelContainer;
    public JPanel brushContainer;
    public JPanel layerContainer;
    private ModelAcessor modelAcessor;
    

    public MainFrame(ModelAcessor modelAcessor) {
        super();
        this.modelAcessor = modelAcessor;
    }

    @Override
    protected void registerAllViews() {
        views.put(BrushPanelView.class, new BrushPanelView(this, null));
        views.put(LayersPanelView.class, new LayersPanelView(this, new Document(500,400)));
        views.put(DrawingAreaView.class, new DrawingAreaView(this));
        views.put(MenuView.class, new MenuView(this));
    }

    @Override
    protected void registerAllControllers() {
        controllers.put(BrushPanelController.class, new BrushPanelController(this));
        controllers.put(BrushPanelController.class, new BrushPanelController(this));
        controllers.put(LayerPanelController.class, new LayerPanelController(this));
        controllers.put(DrawingAreaController.class, new DrawingAreaController(this));
    }

    @Override
    protected JFrame layout() {
        
        JFrame jFrame = new JFrame();
        jFrame.setTitle(".art");
        jFrame.setLayout(new BorderLayout());
        jFrame.setMinimumSize(new Dimension(800, 600));
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        menu = getView(MenuView.class).getContentPane();
        
        jFrame.setJMenuBar(menu);
        
        drawingArea = getView(DrawingAreaView.class).getContentPane();
        drawingContainer = new JScrollPane(drawingArea);
        
        panelContainer = new JPanel();
        panelContainer.setLayout(new BoxLayout(panelContainer, BoxLayout.Y_AXIS));
        panelContainer.setBorder(new LineBorder(Color.BLACK));
        
        brushContainer = getView(BrushPanelView.class).getContentPane();
        layerContainer = getView(LayersPanelView.class).getContentPane();
        
        jFrame.add(drawingContainer, BorderLayout.CENTER);
        
        panelContainer.setPreferredSize(new Dimension(200, 500));
        
        panelContainer.add(brushContainer);
        panelContainer.add(layerContainer);
        
        jFrame.add(panelContainer, BorderLayout.EAST);
        
        return jFrame;
    }
    
}
