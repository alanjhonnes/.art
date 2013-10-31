/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.algorist.art.event;

import com.alanjhonnes.event.Event;
import com.alanjhonnes.event.IEventDispatcher;

/**
 *
 * @author Wellington
 */
public class MovementEvent extends Event {

    public final String POSITION_CHANGED = "positionChanged";
    
    public MovementEvent(IEventDispatcher source, String type) {
        super(source, type);
    }
    
}
