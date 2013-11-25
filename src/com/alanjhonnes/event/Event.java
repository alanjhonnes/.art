/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alanjhonnes.event;

/**
 * Represents an event dispatched by an IEventDispatcher.
 * The Event contains both the type of event and the object that dispatched it.
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
