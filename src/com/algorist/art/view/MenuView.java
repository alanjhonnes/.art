/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.algorist.art.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.ActionMap;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;
import mvc.AbstractFrame;
import mvc.AbstractView;

/**
 *
 * @author alan.jbssa
 */
public class MenuView extends AbstractView<JMenuBar> implements ActionListener {
    
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
    
    public MenuView(AbstractFrame mainFrame) {
        super(mainFrame);
    }
    
    @Override
    protected JMenuBar layout() {
        JMenuBar menuBar = new JMenuBar();
        
        actionMap = new ActionMap();
        
        fileMenu = new JMenu("Arquivo");
        layerMenu = new JMenu("Camadas");
        presetMenu = new JMenu("Presets");
        actionsMenu = new JMenu("Ações");
        
        saveFileItem = new JMenuItem("Salvar");
        saveFileItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));
        saveFileItem.setMnemonic(KeyEvent.VK_S);
        saveFileItem.setActionCommand(SAVE);
        saveFileItem.addActionListener(this);
        
        saveAsItem = new JMenuItem("Salvar como...");
        saveAsItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK | ActionEvent.SHIFT_MASK));
        saveAsItem.setMnemonic(KeyEvent.VK_S);
        saveAsItem.setActionCommand(SAVE_AS);
        saveFileItem.addActionListener(this);
        
        exportItem = new JMenuItem("Exportar...");
        exportItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, ActionEvent.CTRL_MASK));
        exportItem.setMnemonic(KeyEvent.VK_E);
        exportItem.setActionCommand(EXPORT);
        exportItem.addActionListener(this);
        
        newLayerItem = new JMenuItem("Nova camada");
        newLayerItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
        newLayerItem.setMnemonic(KeyEvent.VK_N);
        newLayerItem.setActionCommand(NEW_LAYER);
        newLayerItem.addActionListener(this);
        
        duplicateLayerItem = new JMenuItem("Duplicar camada");
        duplicateLayerItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, ActionEvent.CTRL_MASK));
        duplicateLayerItem.setMnemonic(KeyEvent.VK_D);
        duplicateLayerItem.setActionCommand(DUPLICATE_LAYER);
        duplicateLayerItem.addActionListener(this);
        
        deleteLayerItem = new JMenuItem("Deletar camada");
        deleteLayerItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK| ActionEvent.SHIFT_MASK));
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
        deletePresetItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, ActionEvent.CTRL_MASK| ActionEvent.SHIFT_MASK));
        deletePresetItem.setMnemonic(KeyEvent.VK_P);
        deletePresetItem.setActionCommand(DELETE_PRESET);
        deletePresetItem.addActionListener(this);
        
        undoItem = new JMenuItem("Desfazer");
        undoItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Z, ActionEvent.CTRL_MASK));
        undoItem.setMnemonic(KeyEvent.VK_Z);
        undoItem.setActionCommand(UNDO);
        undoItem.addActionListener(this);
        
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
        JMenuItem source = (JMenuItem)(ae.getSource());
        
    }
    
    
    
    
    
    
}
