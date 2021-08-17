/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vpoesmann.drugstore.consumable;

import com.vpoesmann.drugstore.CannotConsumeException;
import com.vpoesmann.drugstore.Customer;
import com.vpoesmann.drugstore.effect.Poison;

/**
 *
 * @author sogeking
 */
public class PoisonVial extends Consumable {
    private static final int DURATION = 5;

    public PoisonVial() {
        super(20, "potion de poison");
    }
    
    @Override
    public void use(Customer c) throws CannotConsumeException {
        c.addEffect(new Poison(DURATION));
    }
    
}
