/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alanjhonnes.event;

import java.util.Objects;

/**
 * Associative class to store the listener's event type and callback functions 
 * to execute.
 * Also implements the Comparable interface to order the listeners by priority.
 * @author user
 */
public class EventData implements Comparable<EventData> {
    private String type;
    private CallbackFunction callback;
    private int priority;

    public EventData() {
    }

    public EventData(String type) {
        this.type = type;
    }

    public EventData(String type, CallbackFunction callback) {
        this.type = type;
        this.callback = callback;
    }

    public EventData(String type, CallbackFunction callback, int priority) {
        this.type = type;
        this.callback = callback;
        this.priority = priority;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public CallbackFunction getCallback() {
        return callback;
    }

    public void setCallback(CallbackFunction callback) {
        this.callback = callback;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.type);
        hash = 97 * hash + Objects.hashCode(this.callback);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final EventData other = (EventData) obj;
        if (!Objects.equals(this.type, other.type)) {
            return false;
        }
        if (!Objects.equals(this.callback, other.callback)) {
            return false;
        }
        return true;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    @Override
    public int compareTo(EventData ed) {
        int otherPriority = ed.getPriority();
        if(priority < otherPriority){
            return 1;
        }
        else if(priority > otherPriority){
            return -1;
        }
        return 0;
    }
    
    
}
