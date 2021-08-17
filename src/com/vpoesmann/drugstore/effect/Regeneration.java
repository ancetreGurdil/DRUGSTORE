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
public class Regeneration extends Effect {
	private static final int REGEN = 5;
	
	public Regeneration(int nbTurns) {
		super("Regeneration",nbTurns);
	}
	
	@Override
	public void apply(Customer c) {
		if(nbTurns > 0) {
			c.heal(REGEN);
			nbTurns--;
		}
	}
}
