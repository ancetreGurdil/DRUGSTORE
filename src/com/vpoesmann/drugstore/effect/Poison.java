/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vpoesmann.drugstore.effect;

import com.vpoesmann.drugstore.Customer;

/**
 *
 * @author sogeking
 */
public class Poison extends NegativeEffect {
    private static final int DAMAGE_PER_TURN = 10;
    
    public Poison(int nbTurns) {
        super("Poison", nbTurns);
    }

    @Override
    public void apply(Customer c) {
        if (nbTurns > 0) {
            c.hurt(DAMAGE_PER_TURN);
            nbTurns--;
        }
    }
}
