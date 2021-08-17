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
public class RawChicken extends Consumable{
	private static final int DAMAGE = 25;
	private static final int DURATION = 5;
	public RawChicken() {
		super(25,"Poulet cru");
	}
	public void use(Customer c) throws CannotConsumeException {
		if (c.hasFullHunger()){
			throw new CannotConsumeException("y'a des gens en Afrique qui meurent de faim");
		}
		c.hurt(DAMAGE);
		c.addEffect(new Poison(DURATION));
		c.reduceHunger(20);
	}
}
