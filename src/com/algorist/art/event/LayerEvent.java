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
    public static final String SIZE_CHANGED = "sizeChanged";
    public static final String OPACITY_CHANGED = "opacityChanged";
    public static final String BLENDING_MODE_CHANGED = "blendingModeChanged";
    public static final String IMAGE_CHANGED = "imageChanged";

    public LayerEvent(IEventDispatcher source, String type) {
        super(source, type);
    }
}
