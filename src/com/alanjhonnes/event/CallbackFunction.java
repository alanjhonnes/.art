/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alanjhonnes.event;

/**
 * Callback function to be executed whenever an EventListener receives the 
 * respective event.
 * @author user
 */
public interface CallbackFunction {
    public void execute(Event e);
}
