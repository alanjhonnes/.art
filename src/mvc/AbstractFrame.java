package mvc;

import java.awt.Dimension;
import java.awt.Toolkit;

import java.util.HashMap;
import java.util.Map;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;

public abstract class AbstractFrame {

    protected JFrame frame;
    protected final Map<Class<? extends AbstractView<? extends JComponent>>, AbstractView<? extends JComponent>> views = new HashMap<Class<? extends AbstractView<? extends JComponent>>, AbstractView<? extends JComponent>>();
    protected final Map<Class<? extends AbstractController>, AbstractController> controllers = new HashMap<Class<? extends AbstractController>, AbstractController>();
    
    public AbstractFrame() {
        registerAllViews();
        registerAllControllers();
        this.frame = layout();
    }
    
    protected abstract void registerAllViews();
    
    protected abstract void registerAllControllers();
    
    protected abstract JFrame layout();
    
    public void show() {
        frame.pack();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension frameSize = frame.getSize();
        if (frameSize.height > screenSize.height) {
            frameSize.height = screenSize.height;
        }
        if (frameSize.width > screenSize.width) {
            frameSize.width = screenSize.width;
        }
        frame.setLocation((screenSize.width - frameSize.width) / 2, (screenSize.height - frameSize.height) / 2);
        
        frame.setVisible(true);
    }
    
    @SuppressWarnings("unchecked")
    public <V extends AbstractView<? extends JComponent>> V getView(Class<V> viewClass) {
        return (V) views.get(viewClass);
    }
    
//    @SuppressWarnings("unchecked")
//    public <V extends AbstractView<JPanel>> InternalFrameView<V> getInternalFrameView(Class<V> viewClass) {
//        return (InternalFrameView<V>) views.get(viewClass);
//    }
    
    @SuppressWarnings("unchecked")
    public <C extends AbstractController> C getController(Class<C> controllerClass) {
        return (C) controllers.get(controllerClass);
    }
}