/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.algorist.art.model;

import com.alanjhonnes.event.EventDispatcher;
import java.util.List;

/**
 * Will represent the history of states of a particular document, allowing the 
 * user to undo and/or redo his modifications.
 * @author alanjhonnes
 */
public class History extends EventDispatcher {
    
    public List<State> states;
    
}
