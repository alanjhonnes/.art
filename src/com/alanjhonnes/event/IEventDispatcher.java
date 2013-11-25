/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alanjhonnes.event;

/**
 * Interface to be used by classes that need to use the event library but 
 * already have another super class (being unable to extend EventDispatcher).
 * @author user
 */
public interface IEventDispatcher {
    
    public void addEventListener(String type, CallbackFunction callback);
    public void addEventListener(String type, CallbackFunction callback, int priority);
    public void removeEventListener(String type, CallbackFunction callback);
    public boolean hasEventListener(String type);
    public void dispatchEvent(Event event);
    
}
