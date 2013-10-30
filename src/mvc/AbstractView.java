package mvc;

import javax.swing.JComponent;

public abstract class AbstractView<C extends JComponent> {
    protected final AbstractFrame mainFrame;
    protected final C contentPane;

    public AbstractView(AbstractFrame mainFrame) {
        this.mainFrame = mainFrame;
        this.contentPane = layout();
    }

    protected abstract C layout();

    protected AbstractFrame getMainFrame() {
        return mainFrame;
    }

    public C getContentPane() {
        return contentPane;
    }
}
