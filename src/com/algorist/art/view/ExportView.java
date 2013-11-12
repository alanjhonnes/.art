/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.algorist.art.view;

import com.algorist.art.controller.ExportController;
import com.algorist.art.view.display.ExportPanel;
import java.io.File;
import java.io.IOException;
import java.io.Writer;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import mvc.AbstractFrame;
import mvc.AbstractView;

/**
 *
 * @author Asus
 */
public class ExportView extends AbstractView<ExportPanel> {

    private ExportController controller;

    public ExportView(AbstractFrame mainFrame, ExportController controller) {
        super(mainFrame);
        this.controller = controller;
        contentPane.setController(controller);
        controller.setView(this);
    }

    @Override
    protected ExportPanel layout() {
        ExportPanel panel = new ExportPanel();
        return panel;
    }
    
    public void showMessage(String message){
        JOptionPane.showMessageDialog(contentPane, message);
    }
}
