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
public class LayerEvent extends Event {
    public final String SIZE_CHANGED = "sizeChanged";
    public final String OPACITY_CHANGED = "opacityChanged";
    public final String BLENDING_MODE_CHANGED = "blendingModeChanged";

    public LayerEvent(IEventDispatcher source, String type) {
        super(source, type);
    }
}