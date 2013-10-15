/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alanjhonnes.event;

/**
 *
 * @author user
 */
public class Event {

    protected IEventDispatcher source;
    protected String type;
    
    public Event(IEventDispatcher source, String type) {
        this.source = source;
        this.type = type;
    }

    public IEventDispatcher getSource() {
        return source;
    }

    public String getType() {
        return type;
    }
    
}
