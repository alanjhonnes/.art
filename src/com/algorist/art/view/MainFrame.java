package com.algorist.art.view;


import com.algorist.art.ModelAcessor;
import com.algorist.art.controller.BrushPanelController;
import com.algorist.art.controller.DocumentsController;
import com.algorist.art.controller.DocumentController;
import com.algorist.art.controller.LayerPanelController;
import com.algorist.art.controller.MenuController;
import com.algorist.art.controller.ParameterEditorController;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;
import mvc.AbstractFrame;

public class MainFrame extends AbstractFrame {
    
    public JMenuBar menu;
    
    public JScrollPane drawingContainer;
    public JLayeredPane drawingArea;
    
    public JScrollPane panelScroller;
    public JScrollPane brushScroller;
    public JScrollPane layerScroller;
    
    public JPanel panelContainer;
    public JPanel brushContainer;
    public JPanel layerContainer;
    private ModelAcessor modelAcessor;
    
    private DocumentsController documentsController;
    private BrushPanelController brushPanelController;
    private MenuController menuController;
    private ParameterEditorController parameterController;
    
    

    public MainFrame(ModelAcessor modelAcessor) {
        this.modelAcessor = modelAcessor;
        
        documentsController = new DocumentsController(this, modelAcessor.getArt());
        brushPanelController = new BrushPanelController(this, modelAcessor.getArt());
        menuController = new MenuController(this, modelAcessor.getArt());
        parameterController = new ParameterEditorController(this, modelAcessor.getArt());
        registerAllViews();
        registerAllControllers();
        this.frame = layout();
    }

    @Override
    protected void registerAllViews() {
        views.put(ParameterEditorView.class, new ParameterEditorView(this, parameterController));
        views.put(BrushPanelView.class, new BrushPanelView(this, brushPanelController, modelAcessor.getArt()));
        views.put(LayersPanelView.class, new LayersPanelView(this, modelAcessor.getArt().getCurrentDocument()));
        views.put(DocumentsView.class, new DocumentsView(this, modelAcessor.getArt(), documentsController));
        views.put(MenuView.class, new MenuView(this, menuController, modelAcessor.getArt()));
        
    }

    @Override
    protected void registerAllControllers() {
        controllers.put(BrushPanelController.class, brushPanelController);
        controllers.put(LayerPanelController.class, new LayerPanelController(this));
        controllers.put(DocumentController.class, documentsController);
    }

    @Override
    protected JFrame layout() {
        
        JFrame jFrame = new JFrame();
        jFrame.setTitle(".art");
        jFrame.setLayout(new BorderLayout());
        jFrame.setMinimumSize(new Dimension(800, 500));
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        menu = getView(MenuView.class).getContentPane();
        
        jFrame.setJMenuBar(menu);
        
        drawingContainer = new JScrollPane(drawingArea);
        
        panelContainer = new JPanel();
        panelContainer.setLayout(new BoxLayout(panelContainer, BoxLayout.Y_AXIS));
        panelContainer.setBorder(new LineBorder(Color.BLACK));
        
        brushContainer = getView(BrushPanelView.class).getContentPane();
        layerContainer = getView(LayersPanelView.class).getContentPane();
        
        jFrame.add(getView(DocumentsView.class).getContentPane(), BorderLayout.CENTER);
        
        panelContainer.setPreferredSize(new Dimension(240, 500));
        
        panelContainer.add(brushContainer);
        panelContainer.add(getView(ParameterEditorView.class).getContentPane());
        //panelContainer.add(layerContainer);
        
        jFrame.add(panelContainer, BorderLayout.EAST);
        
        return jFrame;
    }
    
}
