/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vpoesmann.drugstore.consumable;

import com.vpoesmann.drugstore.CannotConsumeException;
import com.vpoesmann.drugstore.Customer;

/**
 *
 * @author sogeking
 */
public class MagicPotion extends Consumable {


    public MagicPotion() {
        super(15, "Potion Magique");
    }
    @Override
    public void use(Customer c) throws CannotConsumeException {
        if(c.hasFullMP()){
            throw new CannotConsumeException("MP déjà au maximum");
        }
        if (c.hasEffect("Silence")){
            throw new CannotConsumeException("tu es réduit au silence");
        }
        c.addMp();

   }
}
