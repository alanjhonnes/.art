/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alanjhonnes.event;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 *
 * @author user
 */
public class EventDispatcher implements IEventDispatcher {
    
    private List<EventData> listeners;

    public EventDispatcher() {
        this.listeners = new ArrayList<>();
    }
    
    @Override
    public void dispatchEvent(Event event) {
        for (EventData eventData : listeners) {
            if(event.getType().equals(eventData.getType())){
                eventData.getCallback().execute(event);
            }
        }
    }
    
    @Override
    public void addEventListener(String type, CallbackFunction callback, int priority) {
        EventData eventData = new EventData(type, callback);
        if(!listeners.contains(eventData)){
            listeners.add(eventData);
        }
    }

    @Override
    public void addEventListener(String type, CallbackFunction callback) {
        addEventListener(type, callback, 0);
    }

    @Override
    public void removeEventListener(String type, CallbackFunction callback) {
        EventData eventData = new EventData(type, callback);
        for (Iterator<EventData> it = listeners.iterator(); it.hasNext();) {
            EventData storedEventData = it.next();
            if(eventData.equals(storedEventData)){
                it.remove();
            }
        }
    }

    @Override
    public boolean hasEventListener(String type) {
        for (EventData eventData : listeners) {
            if(eventData.getType().equals(type)){
                return true;
            }
        }
        return false;
    }
    
    public void removeAllEventListeners(){
        for (Iterator<EventData> it = listeners.iterator(); it.hasNext();) {
            EventData eventData = it.next();
            it.remove();
        }
    }
    
}
