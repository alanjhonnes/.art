/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alanjhonnes.event;

/**
 *
 * @author user
 */
public interface IEventDispatcher {
    
    public void addEventListener(String type, CallbackFunction callback);
    public void addEventListener(String type, CallbackFunction callback, int priority);
    public void removeEventListener(String type, CallbackFunction callback);
    public boolean hasEventListener(String type);
    public void dispatchEvent(Event event);
    
}
