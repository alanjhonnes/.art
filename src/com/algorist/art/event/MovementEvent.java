/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.algorist.art.event;

import com.alanjhonnes.event.Event;
import com.alanjhonnes.event.IEventDispatcher;

/**
 *
 * @author alanjhonnes
 */
public class MovementEvent extends Event {

    public static final String POSITION_CHANGED = "positionChanged";
    public static final String TIMER_TICK = "timerTick";
    public static final String ENDED = "ended";
    
    public MovementEvent(IEventDispatcher source, String type) {
        super(source, type);
    }
    
}
