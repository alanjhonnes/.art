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
public class ArtEvent extends Event {

    public ArtEvent(IEventDispatcher source, String type) {
        super(source, type);
    }
    
}
