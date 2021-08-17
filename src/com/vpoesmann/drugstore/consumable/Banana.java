/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vpoesmann.drugstore.consumable;

import com.vpoesmann.drugstore.CannotConsumeException;
import com.vpoesmann.drugstore.Customer;

/**
 * @author sogeking
 */

public class Banana extends Consumable {
    private static final int DUREE = 5;

    public Banana() {
        super(10, "Banane");
    }

    public void use(Customer c) throws CannotConsumeException {
        if (c.hasFullHP() && c.hasFullHunger()) {
            throw new CannotConsumeException("Santé déjà au maximum et repus ");
        }
        c.heal(DUREE);
        c.reduceHunger(10);
    }
}
