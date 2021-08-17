/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vpoesmann.drugstore.effect;

import com.vpoesmann.drugstore.Customer;
import java.util.Locale;

/**
 *
 * @author sogeking
 */
public abstract class Effect {
    protected String name;
    protected int nbTurns;
    
    public Effect(String name, int nbTurns) {
        this.name = name;
        this.nbTurns = nbTurns;
    }
    
    public int getNbTurns() {
        return nbTurns;
    }
    
    public String getName() {
        return name;
    }
    
    public boolean isStillRunning() {
        return nbTurns > 0;
    }
    
    public abstract void apply(Customer c);
    
    public String toString() {
        return String.format(Locale.FRANCE, "%s : %d", name, nbTurns);
    }
}
