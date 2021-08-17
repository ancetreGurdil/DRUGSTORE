/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vpoesmann.drugstore.consumable;

import com.vpoesmann.drugstore.CannotConsumeException;
import com.vpoesmann.drugstore.Customer;
import com.vpoesmann.drugstore.effect.Silence;

/**
 *
 * @author sogeking
 */
public class SilencePotion extends Consumable {
    private static final int DURATION = 5;

    public SilencePotion() {
        super(10, "Potion de silence");
    }
    
    @Override
    public void use(Customer c) throws CannotConsumeException {
        c.addEffect(new Silence(DURATION));
    }
    
}
