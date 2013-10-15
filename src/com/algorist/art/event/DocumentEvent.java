/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.algorist.art.event;

import com.alanjhonnes.event.Event;
import com.alanjhonnes.event.IEventDispatcher;

/**
 *
 * @author user
 */
public class DocumentEvent extends Event {
    public final String SIZE_CHANGED = "sizeChanged";

    public DocumentEvent(IEventDispatcher source, String type) {
        super(source, type);
    }
    
    
}
