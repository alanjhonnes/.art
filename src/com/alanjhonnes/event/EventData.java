/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alanjhonnes.event;

import java.util.Objects;

/**
 *
 * @author user
 */
public class EventData {
    private String type;
    private CallbackFunction callback;

    public EventData() {
    }

    public EventData(String type) {
        this.type = type;
    }

    public EventData(String type, CallbackFunction callback) {
        this.type = type;
        this.callback = callback;
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
    
    
}
