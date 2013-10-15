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
public class HistoryEvent extends Event {
    
    public final String STATE_ADDED = "stateAdded";

    public HistoryEvent(IEventDispatcher source, String type) {
        super(source, type);
    }
    
}
