package mvc;

public abstract class AbstractController {
	private final AbstractFrame mainFrame;

	public AbstractController(AbstractFrame mainFrame) {
		this.mainFrame = mainFrame;
	}

	protected AbstractFrame getMainFrame() {
		return mainFrame;
	}
}
