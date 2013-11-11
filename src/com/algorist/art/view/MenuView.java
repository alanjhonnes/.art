/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.algorist.art.view;

import com.algorist.art.FileManager;
import com.algorist.art.controller.ExportController;
import com.algorist.art.controller.MenuController;
import com.algorist.art.model.Art;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.ActionMap;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;
import javax.swing.filechooser.FileNameExtensionFilter;
import mvc.AbstractFrame;
import mvc.AbstractView;

/**
 *
 * @author alan.jbssa
 */
public class MenuView extends AbstractView<JMenuBar> implements ActionListener {

    public final String NEW_DOCUMENT = "newDocument";
    public final String CLOSE_DOCUMENT = "closeDocument";
    public final String OPEN_DOCUMENT = "openDocument";
    public final String SAVE = "Save";
    public final String SAVE_AS = "SaveAs";
    public final String EXPORT = "Export";
    public final String UNDO = "Undo";
    public final String NEW_LAYER = "NewLayer";
    public final String DUPLICATE_LAYER = "DuplicateLayer";
    public final String DELETE_LAYER = "DeleteLayer";
    public final String SAVE_PRESET = "SavePreset";
    public final String NEW_PRESET = "NewPreset";
    public final String DELETE_PRESET = "DeletePreset";
    public ActionMap actionMap;
    public JMenu fileMenu;
    public JMenu layerMenu;
    public JMenu presetMenu;
    public JMenu actionsMenu;
    public JMenuItem newDocumentItem;
    public JMenuItem closeDocumentItem;
    public JMenuItem openDocumentItem;
    public JMenuItem saveFileItem;
    public JMenuItem saveAsItem;
    public JMenuItem exportItem;
    public JMenuItem newLayerItem;
    public JMenuItem duplicateLayerItem;
    public JMenuItem deleteLayerItem;
    public JMenuItem savePresetItem;
    public JMenuItem newPresetItem;
    public JMenuItem deletePresetItem;
    public JMenuItem undoItem;
    private MenuController controller;
    private Art model;

    public MenuView(AbstractFrame mainFrame, MenuController controller, Art artModel) {
        super(mainFrame);
        this.controller = controller;
        this.model = artModel;
    }

    @Override
    protected JMenuBar layout() {
        JMenuBar menuBar = new JMenuBar();

        actionMap = new ActionMap();

        fileMenu = new JMenu("Arquivo");
        layerMenu = new JMenu("Camadas");
        presetMenu = new JMenu("Presets");
        actionsMenu = new JMenu("Ações");

        newDocumentItem = new JMenuItem("Novo");
        newDocumentItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
        newDocumentItem.setMnemonic(KeyEvent.VK_N);
        newDocumentItem.setActionCommand(NEW_DOCUMENT);
        newDocumentItem.addActionListener(this);

        closeDocumentItem = new JMenuItem("Fechar");
        closeDocumentItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_W, ActionEvent.CTRL_MASK));
        closeDocumentItem.setMnemonic(KeyEvent.VK_W);
        closeDocumentItem.setActionCommand(CLOSE_DOCUMENT);
        closeDocumentItem.addActionListener(this);

        openDocumentItem = new JMenuItem("Abrir...");
        openDocumentItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, ActionEvent.CTRL_MASK));
        openDocumentItem.setMnemonic(KeyEvent.VK_O);
        openDocumentItem.setActionCommand(OPEN_DOCUMENT);
        openDocumentItem.addActionListener(this);

        saveFileItem = new JMenuItem("Salvar");
        saveFileItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));
        saveFileItem.setMnemonic(KeyEvent.VK_S);
        saveFileItem.setActionCommand(SAVE);
        saveFileItem.addActionListener(this);

        saveAsItem = new JMenuItem("Salvar como...");
        saveAsItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK | ActionEvent.SHIFT_MASK));
        saveAsItem.setMnemonic(KeyEvent.VK_S);
        saveAsItem.setActionCommand(SAVE_AS);
        saveAsItem.addActionListener(this);

        exportItem = new JMenuItem("Exportar...");
        exportItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, ActionEvent.CTRL_MASK));
        exportItem.setMnemonic(KeyEvent.VK_E);
        exportItem.setActionCommand(EXPORT);
        exportItem.addActionListener(this);

        newLayerItem = new JMenuItem("Nova camada");
        newLayerItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK | ActionEvent.SHIFT_MASK));
        newLayerItem.setMnemonic(KeyEvent.VK_N);
        newLayerItem.setActionCommand(NEW_LAYER);
        newLayerItem.addActionListener(this);

        duplicateLayerItem = new JMenuItem("Duplicar camada");
        duplicateLayerItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, ActionEvent.CTRL_MASK));
        duplicateLayerItem.setMnemonic(KeyEvent.VK_D);
        duplicateLayerItem.setActionCommand(DUPLICATE_LAYER);
        duplicateLayerItem.addActionListener(this);

        deleteLayerItem = new JMenuItem("Deletar camada");
        deleteLayerItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK | ActionEvent.SHIFT_MASK));
        deleteLayerItem.setMnemonic(KeyEvent.VK_N);
        deleteLayerItem.setActionCommand(DELETE_LAYER);
        deleteLayerItem.addActionListener(this);

        newPresetItem = new JMenuItem("Novo preset");
        newPresetItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, ActionEvent.CTRL_MASK));
        newPresetItem.setMnemonic(KeyEvent.VK_P);
        newPresetItem.setActionCommand(NEW_PRESET);
        newPresetItem.addActionListener(this);

        savePresetItem = new JMenuItem("Salvar preset");
        savePresetItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, ActionEvent.CTRL_MASK));
        savePresetItem.setMnemonic(KeyEvent.VK_A);
        savePresetItem.setActionCommand(SAVE_PRESET);
        savePresetItem.addActionListener(this);

        deletePresetItem = new JMenuItem("Deletar Preset");
        deletePresetItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, ActionEvent.CTRL_MASK | ActionEvent.SHIFT_MASK));
        deletePresetItem.setMnemonic(KeyEvent.VK_P);
        deletePresetItem.setActionCommand(DELETE_PRESET);
        deletePresetItem.addActionListener(this);

        undoItem = new JMenuItem("Desfazer");
        undoItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Z, ActionEvent.CTRL_MASK));
        undoItem.setMnemonic(KeyEvent.VK_Z);
        undoItem.setActionCommand(UNDO);
        undoItem.addActionListener(this);

        fileMenu.add(newDocumentItem);
        fileMenu.add(closeDocumentItem);
        fileMenu.add(openDocumentItem);
        fileMenu.add(saveFileItem);
        fileMenu.add(saveAsItem);
        fileMenu.add(exportItem);

        layerMenu.add(newLayerItem);
        layerMenu.add(duplicateLayerItem);
        layerMenu.add(deleteLayerItem);

        presetMenu.add(savePresetItem);
        presetMenu.add(newPresetItem);
        presetMenu.add(deletePresetItem);

        actionsMenu.add(undoItem);

        menuBar.add(fileMenu);
        menuBar.add(layerMenu);
        menuBar.add(presetMenu);
        menuBar.add(actionsMenu);

        return menuBar;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        JMenuItem source = (JMenuItem) (ae.getSource());
        switch (source.getActionCommand()) {
            case NEW_DOCUMENT:
                controller.newDocument();
                break;
            case CLOSE_DOCUMENT:
                controller.closeDocument();
                break;
            case SAVE: {
                JFileChooser chooser = new JFileChooser();
                FileNameExtensionFilter filter = new FileNameExtensionFilter("Arquivos .art", "art");
                chooser.setFileFilter(filter);
                int returnVal = chooser.showSaveDialog(getMainFrame().getFrame());
                if (returnVal == JFileChooser.APPROVE_OPTION) {
                    controller.saveDocument(chooser.getSelectedFile().getAbsolutePath());
                }
                break;
            }
            case SAVE_AS: {
                JFileChooser chooser = new JFileChooser();
                FileNameExtensionFilter filter = new FileNameExtensionFilter("Arquivos .art", "art");
                chooser.setFileFilter(filter);
                int returnVal = chooser.showSaveDialog(getMainFrame().getFrame());
                if (returnVal == JFileChooser.APPROVE_OPTION) {
                    controller.saveDocument(chooser.getSelectedFile().getAbsolutePath());
                }

                break;
            }
            case OPEN_DOCUMENT: {
                JFileChooser chooser = new JFileChooser();
                FileNameExtensionFilter filter = new FileNameExtensionFilter("Arquivos .art", "art");
                chooser.setFileFilter(filter);
                int returnVal = chooser.showOpenDialog(getMainFrame().getFrame());
                if (returnVal == JFileChooser.APPROVE_OPTION) {
                    controller.loadDocument(chooser.getSelectedFile());
                }
                break;
            }

            case EXPORT: {
                JFrame frame = new JFrame("Exportar");
                ExportView exportView = new ExportView(getMainFrame(), new ExportController(getMainFrame(), model.getCurrentDocument()));
                frame.add(exportView.getContentPane());
                frame.pack();
                frame.setVisible(true);
                break;
            }
                
            case NEW_LAYER: {
                controller.addLayer();
                break;
            }
        }
    }

    private void Dimension(int i, int i0) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
