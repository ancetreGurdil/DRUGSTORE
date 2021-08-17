/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vpoesmann.drugstore.consumable;

import com.vpoesmann.drugstore.CannotConsumeException;
import com.vpoesmann.drugstore.Customer;
import com.vpoesmann.drugstore.effect.Regeneration;

/**
 *
 * @author sogeking
 */
public class LifePotion extends Consumable{
	private static final int REGEN = 5;
	
	public LifePotion() {
		super(30,"Potion de vie");
	}
	
	public void use(Customer c) throws CannotConsumeException {
		if(c.hasFullHP()) {
			throw new CannotConsumeException("Santé déjà au maximum"); 
		}
		c.addEffect(new Regeneration(REGEN));
	}
}
